// SPDX-License-Identifier: GPL-2.0+
/*
 * Configuation settings for the EMAC SoM-A5D36.
 *
 * Copyright (C) 2023 EMAC Inc.
 *
 * based on sama5d3xek.c by:
 * Copyright (C) 2012 - 2013 Atmel Corporation
 * Bo Shen <voice.shen@atmel.com>
 */

#include <common.h>
#include <init.h>
#include <asm/global_data.h>
#include <asm/io.h>
#include <asm/arch/sama5d3_smc.h>
#include <asm/arch/at91_common.h>
#include <asm/arch/at91_rstc.h>
#include <asm/arch/gpio.h>
#include <asm/arch/clk.h>
#include <debug_uart.h>
#include <env.h>
#include <linux/ctype.h>
#include <spl.h>
#include <asm/arch/atmel_mpddrc.h>
#include <asm/arch/at91_wdt.h>
#include <led.h>
#include <linux/err.h>

DECLARE_GLOBAL_DATA_PTR;

/* ------------------------------------------------------------------------- */
/*
 * Miscelaneous platform dependent initialisations
 */

int smc_config_cpld(void)
{
	struct at91_smc *smc = (struct at91_smc *)ATMEL_BASE_SMC;

	at91_periph_clk_enable(ATMEL_ID_SMC);

	writel(AT91_SMC_SETUP_NWE(2) | AT91_SMC_SETUP_NCS_WR(1) |
							AT91_SMC_SETUP_NRD(2) | AT91_SMC_SETUP_NCS_RD(1),
							&smc->cs[2].setup);
	writel(AT91_SMC_PULSE_NWE(3) | AT91_SMC_PULSE_NCS_WR(5) |
							AT91_SMC_PULSE_NRD(3) | AT91_SMC_PULSE_NCS_RD(5),
							&smc->cs[2].pulse);
	writel(AT91_SMC_CYCLE_NWE(8) | AT91_SMC_CYCLE_NRD(8),
							&smc->cs[2].cycle);
	writel(AT91_SMC_TIMINGS_NFSEL(0), &smc->cs[2].timings);
	writel(AT91_SMC_MODE_RM_NRD | AT91_SMC_MODE_WM_NWE |
							AT91_SMC_MODE_EXNW_DISABLE |
							AT91_SMC_MODE_DBW_8 |
							AT91_SMC_MODE_TDF_CYCLE(3),
							&smc->cs[2].mode);

	at91_set_a_periph(AT91_PIO_PORTE, 28, 0); /* NCS2 */

	return 0;
}

// #ifdef CONFIG_CMD_USB
// static void sama5d3xek_usb_hw_init(void)
// {
// 	at91_set_pio_output(AT91_PIO_PORTD, 25, 0);
// 	at91_set_pio_output(AT91_PIO_PORTD, 26, 0);
// 	at91_set_pio_output(AT91_PIO_PORTD, 27, 0);
// }
// #endif

// #ifdef CONFIG_GENERIC_ATMEL_MCI
// static void sama5d3xek_mci_hw_init(void)
// {
// 	at91_set_pio_output(AT91_PIO_PORTB, 10, 0);	/* MCI0 Power */
// }
// #endif

#ifdef CONFIG_DEBUG_UART_BOARD_INIT
void board_debug_uart_init(void)
{
	at91_seriald_hw_init();
	at91_serial1_hw_init();
}
#endif

#ifdef CONFIG_BOARD_EARLY_INIT_F
int board_early_init_f(void)
{
#ifdef CONFIG_DEBUG_UART
	debug_uart_init();
#endif
	return 0;
}
#endif

int board_init(void)
{
	/* adress of boot parameters */
	gd->bd->bi_boot_params = CONFIG_SYS_SDRAM_BASE + 0x100;

// #ifdef CONFIG_CMD_USB
// 	sama5d3xek_usb_hw_init();
// #endif
// #ifdef CONFIG_GENERIC_ATMEL_MCI
// 	sama5d3xek_mci_hw_init();
// #endif
	return 0;
}

int dram_init(void)
{
	gd->ram_size = get_ram_size((void *)CONFIG_SYS_SDRAM_BASE,
				    CONFIG_SYS_SDRAM_SIZE);
	return 0;
}

#ifdef CONFIG_BOARD_LATE_INIT
int board_late_init(void)
{
#ifdef CONFIG_ENV_VARS_UBOOT_RUNTIME_CONFIG

#if CONFIG_IS_ENABLED(SOMA5D36_DTB)
	env_set("dtb_name", "som-a5d36.dtb");
#endif
#if CONFIG_IS_ENABLED(SOMA536M_DTB)
	env_set("dtb_name", "som-a536m.dtb");
#endif
#if CONFIG_IS_ENABLED(SOMA536P_DTB)
	env_set("dtb_name", "som-a536p.dtb");
#endif

#endif
#ifdef CONFIG_DM_VIDEO
	at91_video_show_board_info();
	at91_set_pio_output(AT91_PIO_PORTD, 5, 1);
#endif
	led_default_state();
	return 0;
}
#endif

/* SPL */
#ifdef CONFIG_SPL_BUILD
void spl_board_init(void)
{
	smc_config_cpld();
	at91_set_pio_output(AT91_PIO_PORTA, 24, 0);
}

static void ddr2_conf(struct atmel_mpddrc_config *ddr2)
{
	ddr2->md = (ATMEL_MPDDRC_MD_DBW_32_BITS | ATMEL_MPDDRC_MD_LPDDR2_SDRAM);

	ddr2->cr = (ATMEL_MPDDRC_CR_NC_COL_10 |
		    ATMEL_MPDDRC_CR_NR_ROW_14 |
		    ATMEL_MPDDRC_CR_CAS_DDR_CAS3 |
		    ATMEL_MPDDRC_CR_ZQ_SHORT |
		    ATMEL_MPDDRC_CR_NB_8BANKS |
		    ATMEL_MPDDRC_CR_UNAL_SUPPORTED);
	/*
	 * As the DDR2-SDRAm device requires a refresh time is 7.8125us
	 * when DDR run at 133MHz, so it needs (7.8125us * 133MHz / 10^9) clocks
	 */
	ddr2->rtr = 0x202;
	ddr2->tim_cal = 12;

	ddr2->tpr0 = (6 << ATMEL_MPDDRC_TPR0_TRAS_OFFSET |
		      2 << ATMEL_MPDDRC_TPR0_TRCD_OFFSET |
		      2 << ATMEL_MPDDRC_TPR0_TWR_OFFSET |
		      8 << ATMEL_MPDDRC_TPR0_TRC_OFFSET |
		      2 << ATMEL_MPDDRC_TPR0_TRP_OFFSET |
		      2 << ATMEL_MPDDRC_TPR0_TRRD_OFFSET |
		      2 << ATMEL_MPDDRC_TPR0_TWTR_OFFSET |
		      3 << ATMEL_MPDDRC_TPR0_TMRD_OFFSET);

	ddr2->tpr1 = (2 << ATMEL_MPDDRC_TPR1_TXP_OFFSET |
		      18 << ATMEL_MPDDRC_TPR1_TXSNR_OFFSET |
		      17 << ATMEL_MPDDRC_TPR1_TRFC_OFFSET);

	ddr2->tpr2 = (8 << ATMEL_MPDDRC_TPR2_TFAW_OFFSET |
		      2 << ATMEL_MPDDRC_TPR2_TRTP_OFFSET |
		      3 << ATMEL_MPDDRC_TPR2_TRPA_OFFSET |
		      1 << ATMEL_MPDDRC_TPR2_TXARDS_OFFSET |
		      1 << ATMEL_MPDDRC_TPR2_TXARD_OFFSET);
}

void mem_init(void)
{
	struct atmel_mpddrc_config ddr2;

	ddr2_conf(&ddr2);

	/* Enable MPDDR clock */
	at91_periph_clk_enable(ATMEL_ID_MPDDRC);
	at91_system_clk_enable(AT91_PMC_DDR);

	/* DDRAM2 Controller initialize */
	lpddr2_init(ATMEL_BASE_MPDDRC, ATMEL_BASE_DDRCS, &ddr2);
}

void at91_pmc_init(void)
{
	u32 tmp;

	tmp = AT91_PMC_PLLAR_29 |
	      AT91_PMC_PLLXR_PLLCOUNT(0x3f) |
	      AT91_PMC_PLLXR_MUL(43) |
	      AT91_PMC_PLLXR_DIV(1);
	at91_plla_init(tmp);

	at91_pllicpr_init(AT91_PMC_IPLL_PLLA(0x3));

	tmp = AT91_PMC_MCKR_MDIV_4 |
	      AT91_PMC_MCKR_CSS_PLLA;
	at91_mck_init(tmp);
}
#endif
