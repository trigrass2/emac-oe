// SPDX-License-Identifier: GPL-2.0+
/*
 * Configuation settings for the EMAC SoM-A5D35.
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
#include <asm/arch/atmel_mpddrc.h>
#include <asm/arch/at91_wdt.h>
#include <led.h>
#include <linux/err.h>
#include <miiphy.h>

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

#ifdef CONFIG_GENERIC_ATMEL_MCI
static void at91_mci1_hw_init(void)
{
	at91_pio3_set_a_periph(AT91_PIO_PORTB, 19, 0);	/* MCI1 CMD */
	at91_pio3_set_a_periph(AT91_PIO_PORTB, 20, 0);	/* MCI1 DA0 */
	at91_pio3_set_a_periph(AT91_PIO_PORTB, 21, 0);	/* MCI1 DA1 */
	at91_pio3_set_a_periph(AT91_PIO_PORTB, 22, 0);        /* MCI1 DA2 */
	at91_pio3_set_a_periph(AT91_PIO_PORTB, 23, 0);        /* MCI1 DA3 */
	at91_pio3_set_a_periph(AT91_PIO_PORTB, 24, 0);        /* MCI1 CLK */

	/* Enable clock */
	at91_periph_clk_enable(ATMEL_ID_MCI1);
}
#endif

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
	gd->bd->bi_boot_params = CFG_SYS_SDRAM_BASE + 0x100;

#ifdef CONFIG_GENERIC_ATMEL_MCI
	at91_mci_hw_init();
#endif
#ifdef CONFIG_MACB
	at91_macb_hw_init();
#endif
	return 0;
}

/**
 * KSZ8081
 */
#define MII_KSZ8081_REFERENCE_CLOCK_SELECT	0x1f
#define RMII_50MHz_CLOCK	0x8180

int board_phy_config(struct phy_device *phydev)
{
	/* Set 50 MHz reference clock */
	phy_write(phydev, MDIO_DEVAD_NONE, MII_KSZ8081_REFERENCE_CLOCK_SELECT,
		  RMII_50MHz_CLOCK);

	return genphy_config(phydev);
}

int dram_init(void)
{
	gd->ram_size = get_ram_size((void *)CFG_SYS_SDRAM_BASE,
				    CFG_SYS_SDRAM_SIZE);
	return 0;
}

#ifdef CONFIG_BOARD_LATE_INIT
int board_late_init(void)
{
	return 0;
}
#endif

#ifdef CONFIG_LAST_STAGE_INIT
int last_stage_init(void)
{
	// eth_init();
	return 0;
}
#endif
