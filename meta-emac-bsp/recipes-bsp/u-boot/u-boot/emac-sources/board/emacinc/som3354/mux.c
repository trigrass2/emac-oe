/*
 * mux.c
 *
 * Copyright (C) 2015 EMAC Inc. - http://www.emacinc.com/
 *
 * SPDX-License-Identifier:	GPL-2.0+
 */

#include <common.h>
#include <asm/arch/sys_proto.h>
#include <asm/arch/hardware.h>
#include <asm/arch/mux.h>
#include <asm/io.h>
#include <i2c.h>
#include "board.h"

static struct module_pin_mux spi0_pin_mux[] = {
	{OFFSET(spi0_sclk), (MODE(0) | PULLUDEN | RXACTIVE)},		                /* SPI0_SCLK */
	{OFFSET(spi0_d0),   (MODE(0) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* SPI0_D0 */
	{OFFSET(spi0_d1),   (MODE(0) | PULLUDEN | RXACTIVE)},		                /* SPI0_D1 */
	{OFFSET(spi0_cs0),  (MODE(0) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* SPI0_CS0 */
	{OFFSET(spi0_cs1),  (MODE(0) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* SPI0_CS1 */
	{OFFSET(gpmc_ad15), (MODE(7) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* GPIO Carrier CS0 */
	{OFFSET(emu1),      (MODE(7) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* GPIO Carrier CS1 */
	{OFFSET(gpmc_ad14), (MODE(7) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* GPIO Carrier CS2 */
	{OFFSET(mcasp0_aclkr), (MODE(7) | PULLUDEN | PULLUP_EN | RXACTIVE)},	/* GPIO Carrier CS3 */
	{-1},
};

static struct module_pin_mux uart0_pin_mux[] = {
	{OFFSET(uart0_rxd), (MODE(0) | PULLUP_EN | RXACTIVE)},	/* UART0_RXD */
	{OFFSET(uart0_txd), (MODE(0) | PULLUDEN)},	        /* UART0_TXD */
	{-1},
};

static struct module_pin_mux mmc0_pin_mux[] = {
	{OFFSET(mmc0_dat3), (MODE(0) | RXACTIVE | PULLUP_EN)},	/* MMC0_DAT3 */
	{OFFSET(mmc0_dat2), (MODE(0) | RXACTIVE | PULLUP_EN)},	/* MMC0_DAT2 */
	{OFFSET(mmc0_dat1), (MODE(0) | RXACTIVE | PULLUP_EN)},	/* MMC0_DAT1 */
	{OFFSET(mmc0_dat0), (MODE(0) | RXACTIVE | PULLUP_EN)},	/* MMC0_DAT0 */
	{OFFSET(mmc0_clk), (MODE(0) | RXACTIVE | PULLUP_EN)},	/* MMC0_CLK */
	{OFFSET(mmc0_cmd), (MODE(0) | RXACTIVE | PULLUP_EN)},	/* MMC0_CMD */
	{-1},
};

static struct module_pin_mux mmc1_pin_mux[] = {
	{OFFSET(gpmc_ad11), (MODE(2) | RXACTIVE | PULLUP_EN)},  /* MMC1_DAT3 */
	{OFFSET(gpmc_ad10), (MODE(2) | RXACTIVE | PULLUP_EN)},  /* MMC1_DAT2 */
	{OFFSET(gpmc_ad9), (MODE(2) | RXACTIVE | PULLUP_EN)},   /* MMC1_DAT1 */
	{OFFSET(gpmc_ad8), (MODE(2) | RXACTIVE | PULLUP_EN)},   /* MMC1_DAT0 */
	{OFFSET(gpmc_csn1), (MODE(2) | RXACTIVE | PULLUP_EN)},  /* MMC1_CLK */
	{OFFSET(gpmc_csn2), (MODE(2) | RXACTIVE | PULLUP_EN)},  /* MMC1_CMD */
	{OFFSET(emu0), (MODE(7) | PULLDOWN_EN) },               /* SD_PWREN  */
	{-1},
};

static struct module_pin_mux i2c0_pin_mux[] = {
	{OFFSET(i2c0_sda), (MODE(0) | RXACTIVE |
			PULLUP_EN | PULLUDEN | SLEWCTRL)}, /* I2C_DATA */
	{OFFSET(i2c0_scl), (MODE(0) | RXACTIVE |
			PULLUP_EN | PULLUDEN | SLEWCTRL)}, /* I2C_SCLK */
	{-1},
};

static struct module_pin_mux rmii1_pin_mux[] = {
	{OFFSET(mii1_crs), MODE(1)  | RXACTIVE},                /* RMII1_CRS_DV */
	{OFFSET(mii1_rxerr), MODE(1) | RXACTIVE},               /* RMII1_RXERR */
	{OFFSET(mii1_txen), MODE(1)},                           /* RMII1_TXEN */
	{OFFSET(mii1_txd1), MODE(1)},                           /* RMII1_TXD1 */
	{OFFSET(mii1_txd0), MODE(1)},                           /* RMII1_TXD0 */
	{OFFSET(mii1_rxd1), MODE(1) | RXACTIVE},                /* RMII1_RXD1 */
	{OFFSET(mii1_rxd0), MODE(1) | RXACTIVE},                /* RMII1_RXD0 */
	{OFFSET(rmii1_refclk), MODE(0) | RXACTIVE},             /* RMII1_REFCLK */
	{OFFSET(mdio_data), MODE(0) | RXACTIVE | PULLUP_EN},    /* MDIO_DATA */
	{OFFSET(mdio_clk), MODE(0) | PULLUP_EN},                /* MDIO_CLK */
	{OFFSET(mii1_rxd3), MODE(7) | RXACTIVE},                /* ETH_INT~ */
	{OFFSET(mii1_rxd2), MODE(7) | PULLUP_EN | RXACTIVE},    /* ETH_EN */
	{-1},
};

void enable_uart0_pin_mux(void)
{
	configure_module_pin_mux(uart0_pin_mux);
}

void enable_i2c0_pin_mux(void)
{
	configure_module_pin_mux(i2c0_pin_mux);
}

void enable_board_pin_mux(void)
{
	configure_module_pin_mux(rmii1_pin_mux);
	configure_module_pin_mux(mmc0_pin_mux);
	configure_module_pin_mux(mmc1_pin_mux);
	configure_module_pin_mux(spi0_pin_mux);
}
