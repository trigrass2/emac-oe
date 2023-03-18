/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Copyright (C) 2014 Texas Instruments Incorporated - http://www.ti.com
 *
 * Author: Felipe Balbi <balbi@ti.com>
 *
 * Based on board/ti/dra7xx/evm.c
 */
#ifndef _MUX_DATA_EMACINC_SOM5728_H_
#define _MUX_DATA_EMACINC_SOM5728_H_

#include <asm/arch/mux_dra7xx.h>

const struct pad_conf_entry early_padconf[] = {
	/* Console UART */
	{UART3_RXD, (M0 | PIN_INPUT | SLEWCONTROL)},	/* V2 uart3_rxd.uart3_rxd */
    {UART3_TXD, (M0 | PIN_OUTPUT | SLEWCONTROL)},	/* Y1 uart3_txd.uart3_txd */
};

const struct pad_conf_entry emmc_padconf[] = {
	{GPMC_A23, (M1 | PIN_INPUT_PULLUP)},		    /*  J7: gpmc_a23.mmc2_clk */
	{GPMC_CS1, (M1 | PIN_INPUT_PULLUP)},		    /*  H6: gpmc_cs1.mmc2_cmd */
	{GPMC_A24, (M1 | PIN_INPUT_PULLUP)},		    /*  J4: gpmc_a24.mmc2_dat0 */
	{GPMC_A25, (M1 | PIN_INPUT_PULLUP)},		    /*  J6: gpmc_a25.mmc2_dat1 */
	{GPMC_A26, (M1 | PIN_INPUT_PULLUP)},		    /*  H4: gpmc_a26.mmc2_dat2 */
	{GPMC_A27, (M1 | PIN_INPUT_PULLUP)},		    /*  H5: gpmc_a27.mmc2_dat3 */
	{GPMC_A19, (M1 | PIN_INPUT_PULLUP)},		    /*  K7: gpmc_a19.mmc2_dat4 */
	{GPMC_A20, (M1 | PIN_INPUT_PULLUP)},		    /*  M7: gpmc_a20.mmc2_dat5 */
	{GPMC_A21, (M1 | PIN_INPUT_PULLUP)},		    /*  J5: gpmc_a21.mmc2_dat6 */
	{GPMC_A22, (M1 | PIN_INPUT_PULLUP)},		    /*  K6: gpmc_a22.mmc2_dat7 */
	// MMC1
	{MMC1_CLK, (M0 | PIN_INPUT)},	/* W6 mmc1_clk.mmc1_clk */
    {MMC1_CMD, (M0 | PIN_INPUT)},	/* Y6 mmc1_cmd.mmc1_cmd */
    {MMC1_DAT0, (M0 | PIN_INPUT)},	/* AA6 mmc1_dat0.mmc1_dat0 */
    {MMC1_DAT1, (M0 | PIN_INPUT)},	/* Y4 mmc1_dat1.mmc1_dat1 */
    {MMC1_DAT2, (M0 | PIN_INPUT)},	/* AA5 mmc1_dat2.mmc1_dat2 */
    {MMC1_DAT3, (M0 | PIN_INPUT)},	/* Y3 mmc1_dat3.mmc1_dat3 */
    {MMC1_SDCD, (M0 | PIN_INPUT | SLEWCONTROL)},	/* W7 mmc1_sdcd.mmc1_sdcd */
};

const struct pad_conf_entry core_padconf_array_essential_som5728[] = {
	/* Non negotiable pin-muxing */
	// eMMC
	{GPMC_A23, (M1 | PIN_INPUT_PULLUP)},		    /*  J7: gpmc_a23.mmc2_clk */
	{GPMC_CS1, (M1 | PIN_INPUT_PULLUP)},		    /*  H6: gpmc_cs1.mmc2_cmd */
	{GPMC_A24, (M1 | PIN_INPUT_PULLUP)},		    /*  J4: gpmc_a24.mmc2_dat0 */
	{GPMC_A25, (M1 | PIN_INPUT_PULLUP)},		    /*  J6: gpmc_a25.mmc2_dat1 */
	{GPMC_A26, (M1 | PIN_INPUT_PULLUP)},		    /*  H4: gpmc_a26.mmc2_dat2 */
	{GPMC_A27, (M1 | PIN_INPUT_PULLUP)},		    /*  H5: gpmc_a27.mmc2_dat3 */
	{GPMC_A19, (M1 | PIN_INPUT_PULLUP)},		    /*  K7: gpmc_a19.mmc2_dat4 */
	{GPMC_A20, (M1 | PIN_INPUT_PULLUP)},		    /*  M7: gpmc_a20.mmc2_dat5 */
	{GPMC_A21, (M1 | PIN_INPUT_PULLUP)},		    /*  J5: gpmc_a21.mmc2_dat6 */
	{GPMC_A22, (M1 | PIN_INPUT_PULLUP)},		    /*  K6: gpmc_a22.mmc2_dat7 */
	// qSPI Flash
	{GPMC_A13, (M1 | PIN_INPUT )},	/* R3 gpmc_a13.qspi1_rtclk */
    {GPMC_A16, (M1 | PIN_INPUT)},	/* U1 gpmc_a16.qspi1_d0 */
    {GPMC_A17, (M1 | PIN_INPUT)},	/* P3 gpmc_a17.qspi1_d1 */
	{GPMC_A18, (M1 | PIN_OUTPUT)},	/* R2 gpmc_a18.qspi1_sclk */
	{GPMC_CS2, (M1 | PIN_OUTPUT_PULLUP)},		    /*  P2: gpmc_cs2.qspi1_cs0 */
	// GigEth
	{RGMII0_RXD0, (M0 | PIN_INPUT)},	/* W2 rgmii0_rxd0.rgmii0_rxd0 */
	{RGMII0_RXD1, (M0 | PIN_INPUT)},	/* Y2 rgmii0_rxd1.rgmii0_rxd1 */
	{RGMII0_RXD2, (M0 | PIN_INPUT)},	/* V3 rgmii0_rxd2.rgmii0_rxd2 */
	{RGMII0_RXD3, (M0 | PIN_INPUT)},	/* V4 rgmii0_rxd3.rgmii0_rxd3 */
    {RGMII0_TXD0, (M0 | PIN_OUTPUT)},	/* U6 rgmii0_txd0.rgmii0_txd0 */
    {RGMII0_TXD1, (M0 | PIN_OUTPUT)},	/* V6 rgmii0_txd1.rgmii0_txd1 */
    {RGMII0_TXD2, (M0 | PIN_OUTPUT)},	/* U7 rgmii0_txd2.rgmii0_txd2 */
    {RGMII0_TXD3, (M0 | PIN_OUTPUT)},	/* V7 rgmii0_txd3.rgmii0_txd3 */
	{VIN2A_D10, (M3 | PIN_OUTPUT )},	/* vin2a_d10.mdio_clk(gmac_mdio_clk) */
	{VIN2A_D11, (M3 | PIN_INPUT )},	/* vin2a_d11.mdio_d(gmac_mdio_d) */
    {RGMII0_RXCTL, (M0 | PIN_INPUT)},	/* V5 rgmii0_rxctl.rgmii0_rxctl */
    {RGMII0_TXCTL, (M0 | PIN_OUTPUT)},	/* V9 rgmii0_txctl.rgmii0_txctl */
	{RGMII0_TXC, (M0 | PIN_OUTPUT)},	/* W9 rgmii0_txc.rgmii0_txc */
    {RGMII0_RXC, (M0 | PIN_INPUT)},	/* U5 rgmii0_rxc.rgmii0_rxc */
    {RMII_MHZ_50_CLK, (M14 | PIN_INPUT_PULLUP)},	/* RMII_MHZ_50_CLK.gpio5_17 */
	{VIN2A_D16, (M14 | PIN_INPUT )},	/* vin2a_d16.gpio4_24(phy_pps) */
	{VIN2A_D17, (M14 | PIN_OUTPUT )},	/* vin2a_d17.gpio4_25(phy_rst) */
	{VIN2A_D18, (M14 | PIN_INPUT | (1 << 24) )},	/* vin2a_d18.gpio4_26(gig_eth_int_wol) with wakeup enabled*/ 
	{VIN2A_D19, (M14 | PIN_INPUT )},	/* vin2a_d19.gpio4_27(gig_eth_int) */
	// i2c
	{I2C1_SDA, (M0 | PIN_INPUT_PULLUP)},	/* C21 i2c1_sda.i2c1_sda */
    {I2C1_SCL, (M0 | PIN_INPUT_PULLUP)},	/* C20 i2c1_scl.i2c1_scl */
	// PMIC
	{VIN2A_D21, (M14 | PIN_INPUT )},	/* vin2a_d21.gpio4_29(pmic_int) */
	// RTC
	{VIN2A_D22, (M14 | PIN_INPUT )},	/* vin2a_d22.gpio4_30(rtc_int) */
	// Touch controller
	{GPIO6_16, (M0 | PIN_OUTPUT )},	/* gpio6_16.gpio6_16(ts_int) */
	// USB2 HUB (p and m are non muxable)
	{USB2_DRVVBUS, (M0 | PIN_OUTPUT | SLEWCONTROL)},	/* AC10 usb2_drvvbus.usb2_drvvbus */
	{VIN1A_D1, (M14 | PIN_OUTPUT )},	/* vin1a_d1.gpio3_5(usb_hub_rst) */
	//MISC
	{VIN1A_DE0, (M14 | PIN_INPUT )},	/* vin1a_de0.gpio3_0(status_led) */

	/* No driver currently exists in U-Boot for these but they also are not to be changed */
	/* PRUSS2 ETH MDIO */
	{MCASP5_AXR0, (M11 | PIN_OUTPUT )},	/* mcasp5_axr0.pr2_mdio_mdclk*/
	{MCASP5_AXR1, (M11 | PIN_INPUT )},	/* mcasp5_axr1.pr2_mdio_data*/
	/* PRUSS2 ETH0 */
	{MCASP3_ACLKX, (M11 | PIN_INPUT )},	/* mcasp3_aclkx.pr2_mii0_crs */
	{MCASP3_FSX, (M11 | PIN_INPUT_SLEW )},	/* mcasp3_fsx.pr2_mii0_col */
	{MCASP1_AXR12, (M11 | PIN_OUTPUT | SLEWCONTROL )},	/* mcasp1_axr12.pr2_mii0_txd0 */
	{MCASP1_AXR11, (M11 | PIN_OUTPUT | SLEWCONTROL )},	/* mcasp1_axr11.pr2_mii0_txd1 */
	{MCASP1_AXR10, (M11 | PIN_OUTPUT | SLEWCONTROL )},	/* mcasp1_axr10.pr2_mii0_txd2 */
	{MCASP1_AXR9, (M11 | PIN_OUTPUT | SLEWCONTROL )},	/* mcasp1_axr9.pr2_mii0_txd3 */
	{MCASP1_AXR8, (M11 | PIN_OUTPUT | SLEWCONTROL )},	/* mcasp1_axr8.pr2_mii0_txen */
	{MCASP1_AXR1, (M11 | PIN_INPUT_SLEW )},	/* mcasp1_axr1.pr2_mii_mt0_clk */
	{MCASP2_AXR2, (M11 | PIN_INPUT_SLEW )},	/* mcasp2_axr2.pr2_mii0_rxd0 */
	{MCASP2_FSX, (M11 | PIN_INPUT_SLEW )},	/* mcasp2_fsx.pr2_mii0_rxd1 */
	{MCASP2_ACLKX, (M11 | PIN_INPUT )},	/* mcasp2_aclkx.pr2_mii0_rxd2 */
	{MCASP1_AXR15, (M11 | PIN_INPUT_SLEW )},	/* mcasp1_axr15.pr2_mii0_rxd3 */
	{MCASP1_AXR14, (M11 | PIN_INPUT_SLEW )},	/* mcasp1_axr14.pr2_mii0_rxdv */
	{MCASP1_AXR0, (M11 | PIN_INPUT_SLEW )},	/* mcasp1_axr0.pr2_mii0_rxer */
	{MCASP1_AXR13, (M11 | PIN_INPUT_SLEW )},	/* mcasp1_axr13.pr2_mii_mr0_clk */
	{SPI1_CS0, (M14 | PIN_INPUT )},	/* spi1_cs0.gpio7_10(pr2_mii0_intn) */
	{SPI1_D1, (M14 | PIN_OUTPUT)},	/* F16 spi1_d1.gpio7_8(pru_phy1_rstn) */
	{MCASP2_AXR3, (M11 | PIN_INPUT_SLEW )},	/* mcasp2_axr3.pr2_mii0_rxlink */
	/* PRUSS2 ETH1 */
    {XREF_CLK1, (M11 | PIN_INPUT)},	/* E17 xref_clk1.pr2_mii1_crs */
	{XREF_CLK0, (M11 | PIN_INPUT)},	/* D18 xref_clk0.pr2_mii1_col */
	{MMC3_DAT1, (M11 | PIN_OUTPUT )},	/* mmc3_dat1.pr2_mii1_txd0 */
	{MMC3_DAT0, (M11 | PIN_OUTPUT )},	/* mmc3_dat0.pr2_mii1_txd1 */
	{MMC3_CMD, (M11 | PIN_OUTPUT )},	/* mmc3_cmd.pr2_mii1_txd2 */
	{MMC3_CLK, (M11 | PIN_OUTPUT )},	/* mmc3_clk.pr2_mii1_txd3 */
	{GPIO6_11, (M11 | PIN_OUTPUT )},	/* gpio6_11.pr2_mii1_txen */
	{GPIO6_10, (M11 | PIN_INPUT_SLEW )},	/* gpio6_10.pr2_mii_mt1_clk */
	{MMC3_DAT7, (M11 | PIN_INPUT )},	/* mmc3_dat7.pr2_mii1_rxd0 */
	{MMC3_DAT6, (M11 | PIN_INPUT )},	/* mmc3_dat6.pr2_mii1_rxd1 */
	{MMC3_DAT5, (M11 | PIN_INPUT )},	/* mmc3_dat5.pr2_mii1_rxd2 */
	{MMC3_DAT4, (M11 | PIN_INPUT )},	/* mmc3_dat4.pr2_mii1_rxd3 */
	{MMC3_DAT3, (M11 | PIN_INPUT )},	/* mmc3_dat3.pr2_mii1_rxdv */
	{MCASP3_AXR0, (M11 | PIN_INPUT_SLEW )},	/* mcasp3_axr0.pr2_mii1_rxer */
	{MMC3_DAT2, (M11 | PIN_INPUT )},	/* mmc3_dat2.pr2_mii_mr1_clk */
    {SPI1_D0, (M14 | PIN_INPUT)},	/* B25 spi1_d0.gpio7_9(pr2_mii1_intn) */
	{SPI1_SCLK, (M14 | PIN_OUTPUT)},	/* A25 spi1_sclk.gpio7_7(pru_phy2_rstn) */
	{MCASP3_AXR1, (M11 | PIN_INPUT_SLEW )},	/* mcasp3_axr1.pr2_mii1_rxlink */
};

#endif /* _MUX_DATA_EMACINC_SOM5728_H_ */
