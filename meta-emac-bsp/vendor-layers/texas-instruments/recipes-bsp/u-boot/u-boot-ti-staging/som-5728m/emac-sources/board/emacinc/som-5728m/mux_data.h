/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Copyright (C) 2023 EMAC Incorporated - http://www.emacinc.com
 *
 * Author: Brenden Tisler <support@emacinc.com>
 *
 * Based on board/ti/am57xx/board.c
 */
#ifndef _MUX_DATA_EMACINC_SOM_5728M_H_
#define _MUX_DATA_EMACINC_SOM_5728M_H_

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

const struct pad_conf_entry core_padconf_array_essential_som_5728m[] = {
	{DCAN1_RX, 0x5000F}, /* G19 dcan1_rx.dcan1_rx */
	{DCAN1_TX, 0x90000}, /* G20 dcan1_tx.dcan1_tx */
	{GPIO6_15, 0x5000F}, /* F20 gpio6_15.dcan2_rx */
	{GPIO6_14, 0x10002}, /* E21 gpio6_14.dcan2_tx */
	{TMS, 0x50000}, /* F18 tms.tms */
	{TDI, 0xD0000}, /* D23 tdi.tdi */
	{TDO, 0x10000}, /* F19 tdo.tdo */
	{TCLK, 0x50000}, /* E20 tclk.tclk */
	{TRSTN, 0x50000}, /* D20 trstn.trstn */
	{RTCK, 0x10000}, /* E18 rtck.rtck */
	{VIN2A_D2, 0x1000A}, /* D1 vin2a_d2.eCAP1_in_PWM1_out */
	{VIN2A_CLK0, 0x5000A}, /* E1 vin2a_clk0.eQEP1A_in */
	{VIN2A_DE0, 0x5000A}, /* G2 vin2a_de0.eQEP1B_in */
	{VIN2A_FLD0, 0x5000A}, /* H7 vin2a_fld0.eQEP1_index */
	{VIN2A_D5, 0x5000A}, /* F4 vin2a_d5.eQEP2A_in */
	{VIN2A_D6, 0x5000A}, /* C1 vin2a_d6.eQEP2B_in */
	{VIN2A_D7, 0x5000A}, /* E4 vin2a_d7.eQEP2_index */
	{VIN2A_D8, 0x5000A}, /* F5 vin2a_d8.eQEP2_strobe */
	{VIN2A_D13, 0x5000A}, /* C2 vin2a_d13.eQEP3A_in */
	{VIN2A_D14, 0x5000A}, /* C3 vin2a_d14.eQEP3B_in */
	{VIN2A_D15, 0x5000A}, /* C4 vin2a_d15.eQEP3_index */
	{VIN2A_D10, 0x10003}, /* D3 vin2a_d10.mdio_mclk */
	{VIN2A_D11, 0x10003}, /* F6 vin2a_d11.mdio_d */
	{RGMII0_RXD1, 0x50100}, /* Y2 rgmii0_rxd1.rgmii0_rxd1 */
	{RGMII0_RXD2, 0x50100}, /* V3 rgmii0_rxd2.rgmii0_rxd2 */
	{RGMII0_RXD3, 0x50100}, /* V4 rgmii0_rxd3.rgmii0_rxd3 */
	{RGMII0_RXD0, 0x50100}, /* W2 rgmii0_rxd0.rgmii0_rxd0 */
	{RGMII0_TXD0, 0x10100}, /* U6 rgmii0_txd0.rgmii0_txd0 */
	{RGMII0_TXD1, 0x10100}, /* V6 rgmii0_txd1.rgmii0_txd1 */
	{RGMII0_TXD2, 0x10100}, /* U7 rgmii0_txd2.rgmii0_txd2 */
	{RGMII0_TXD3, 0x10100}, /* V7 rgmii0_txd3.rgmii0_txd3 */
	{RGMII0_TXC, 0x10100}, /* W9 rgmii0_txc.rgmii0_txc */
	{RGMII0_TXCTL, 0x10100}, /* V9 rgmii0_txctl.rgmii0_txctl */
	{RGMII0_RXC, 0x50100}, /* U5 rgmii0_rxc.rgmii0_rxc */
	{RGMII0_RXCTL, 0x50100}, /* V5 rgmii0_rxctl.rgmii0_rxctl */
	{VIN1A_DE0, 0x5000E}, /* AD9 vin1a_de0.gpio3_0 */
	{VIN1A_FLD0, 0x5000E}, /* AF9 vin1a_fld0.gpio3_1 */
	{VIN1A_D0, 0x5000E}, /* AE8 vin1a_d0.gpio3_4 */
	{VIN1A_D1, 0x5000E}, /* AD8 vin1a_d1.gpio3_5 */
	{VIN1A_D2, 0x5000E}, /* AG7 vin1a_d2.gpio3_6 */
	{VIN1A_D3, 0x5000E}, /* AH6 vin1a_d3.gpio3_7 */
	{VIN1A_D4, 0x5000E}, /* AH3 vin1a_d4.gpio3_8 */
	{VIN1A_D5, 0x5000E}, /* AH5 vin1a_d5.gpio3_9 */
	{VIN1A_D6, 0x5000E}, /* AG6 vin1a_d6.gpio3_10 */
	{VIN1A_D7, 0x5000E}, /* AH4 vin1a_d7.gpio3_11 */
	{VIN1A_D8, 0x5000E}, /* AG4 vin1a_d8.gpio3_12 */
	{VIN1A_D9, 0x5000E}, /* AG2 vin1a_d9.gpio3_13 */
	{VIN1A_D10, 0x5000E}, /* AG3 vin1a_d10.gpio3_14 */
	{VIN1A_D11, 0x5000E}, /* AG5 vin1a_d11.gpio3_15 */
	{VIN1A_D12, 0x5000E}, /* AF2 vin1a_d12.gpio3_16 */
	{VIN1A_D13, 0x5000E}, /* AF6 vin1a_d13.gpio3_17 */
	{VIN1A_D14, 0x5000E}, /* AF3 vin1a_d14.gpio3_18 */
	{VIN1A_D15, 0x5000E}, /* AF4 vin1a_d15.gpio3_19 */
	{VIN1A_D16, 0x5000E}, /* AF1 vin1a_d16.gpio3_20 */
	{VIN1A_D17, 0x5000E}, /* AE3 vin1a_d17.gpio3_21 */
	{VIN1A_D18, 0x5000E}, /* AE5 vin1a_d18.gpio3_22 */
	{VIN1A_D19, 0x5000E}, /* AE1 vin1a_d19.gpio3_23 */
	{VIN1A_D20, 0x5000E}, /* AE2 vin1a_d20.gpio3_24 */
	{VIN1A_D21, 0x5000E}, /* AE6 vin1a_d21.gpio3_25 */
	{VIN1A_D22, 0x5000E}, /* AD2 vin1a_d22.gpio3_26 */
	{VIN1A_D23, 0x5000E}, /* AD3 vin1a_d23.gpio3_27 */
	{SPI1_SCLK, 0x5000E}, /* A25 spi1_sclk.gpio7_7 */
	{SPI1_D1, 0x5000E}, /* F16 spi1_d1.gpio7_8 */
	{SPI1_D0, 0x5000E}, /* B25 spi1_d0.gpio7_9 */
	{SPI1_CS0, 0x5000E}, /* A24 spi1_cs0.gpio7_10 */
	{SPI2_SCLK, 0x5000E}, /* A26 spi2_sclk.gpio7_14 */
	{SPI2_D1, 0xD000E}, /* B22 spi2_d1.gpio7_15 */
	{SPI2_CS0, 0xD000E}, /* B24 spi2_cs0.gpio7_17 */
	{MCASP1_FSX, 0xD000E}, /* D14 mcasp1_fsx.gpio7_30 */
	{MCASP1_ACLKX, 0x5000E}, /* C14 mcasp1_aclkx.gpio7_31 */
	{GPIO6_16, 0x50000}, /* F21 gpio6_16.gpio6_16 */
	{MMC1_SDWP, 0xD000E}, /* Y9 mmc1_sdwp.gpio6_28 */
	{GPMC_A11, 0x5000E}, /* P9 gpmc_a11.gpio2_1 */
	{GPMC_CS0, 0x5000E}, /* T1 gpmc_cs0.gpio2_19 */
	{GPMC_OEN_REN, 0x5000E}, /* M5 gpmc_oen_ren.gpio2_24 */
	{GPMC_WEN, 0x5000E}, /* M3 gpmc_wen.gpio2_25 */
	{GPMC_BEN0, 0x5000E}, /* N6 gpmc_ben0.gpio2_26 */
	{GPMC_BEN1, 0x5000E}, /* M4 gpmc_ben1.gpio2_27 */
	{GPMC_WAIT0, 0xD000E}, /* N2 gpmc_wait0.gpio2_28 */
	{VIN1A_CLK0, 0x5000E}, /* AG8 vin1a_clk0.gpio2_30 */
	{VIN1B_CLK1, 0xD000E}, /* AH7 vin1b_clk1.gpio2_31 */
	{VOUT1_D2, 0x5000E}, /* F10 vout1_d2.gpio8_2 */
	{VOUT1_D3, 0x5000E}, /* G11 vout1_d3.gpio8_3 */
	{VOUT1_D4, 0x5000E}, /* E9 vout1_d4.gpio8_4 */
	{VOUT1_D5, 0x5000E}, /* F9 vout1_d5.gpio8_5 */
	{VOUT1_D6, 0x5000E}, /* F8 vout1_d6.gpio8_6 */
	{VOUT1_D7, 0x5000E}, /* E7 vout1_d7.gpio8_7 */
	{VOUT1_D10, 0x5000E}, /* D7 vout1_d10.gpio8_10 */
	{VOUT1_D11, 0x5000E}, /* D8 vout1_d11.gpio8_11 */
	{VOUT1_D12, 0x5000E}, /* A5 vout1_d12.gpio8_12 */
	{VOUT1_D13, 0x5000E}, /* C6 vout1_d13.gpio8_13 */
	{VOUT1_D14, 0x5000E}, /* C8 vout1_d14.gpio8_14 */
	{VOUT1_D15, 0x5000E}, /* C7 vout1_d15.gpio8_15 */
	{VOUT1_D18, 0x5000E}, /* A7 vout1_d18.gpio8_18 */
	{VOUT1_D19, 0x5000E}, /* A8 vout1_d19.gpio8_19 */
	{VOUT1_D20, 0x5000E}, /* C9 vout1_d20.gpio8_20 */
	{VOUT1_D21, 0x5000E}, /* A9 vout1_d21.gpio8_21 */
	{VOUT1_D22, 0x5000E}, /* B9 vout1_d22.gpio8_22 */
	{VOUT1_D23, 0x5000E}, /* A10 vout1_d23.gpio8_23 */
	{MCASP1_ACLKR, 0x5000E}, /* B14 mcasp1_aclkr.gpio5_0 */
	{MCASP1_FSR, 0x5000E}, /* J14 mcasp1_fsr.gpio5_1 */
	{MCASP1_AXR4, 0x5000E}, /* E12 mcasp1_axr4.gpio5_6 */
	{MCASP1_AXR5, 0x5000E}, /* F13 mcasp1_axr5.gpio5_7 */
	{VIN2A_D3, 0x5000E}, /* E2 vin2a_d3.gpio4_4 */
	{VIN2A_D4, 0x5000E}, /* D2 vin2a_d4.gpio4_5 */
	{VIN2A_D9, 0x5000E}, /* E6 vin2a_d9.gpio4_10 */
	{VIN2A_D12, 0x5000E}, /* D5 vin2a_d12.gpio4_13 */
	{VIN2A_D16, 0x5000E}, /* B2 vin2a_d16.gpio4_24 */
	{VIN2A_D17, 0x5000E}, /* D6 vin2a_d17.gpio4_25 */
	{VIN2A_D18, 0x5000E}, /* C5 vin2a_d18.gpio4_26 */
	{VIN2A_D19, 0x5000E}, /* A3 vin2a_d19.gpio4_27 */
	{VIN2A_D20, 0x5000E}, /* B3 vin2a_d20.gpio4_28 */
	{VIN2A_D21, 0x5000E}, /* B4 vin2a_d21.gpio4_29 */
	{VIN2A_D22, 0x5000E}, /* B5 vin2a_d22.gpio4_30 */
	{VIN2A_D23, 0x5000E}, /* A4 vin2a_d23.gpio4_31 */
	{SPI1_CS3, 0xD0006}, /* B20 spi1_cs3.hdmi1_cec */
	{SPI1_CS2, 0xD0006}, /* B21 spi1_cs2.hdmi1_hpd */
	{I2C2_SDA, 0x50001}, /* C25 i2c2_sda.hdmi1_ddc_scl */
	{I2C2_SCL, 0x50001}, /* F17 i2c2_scl.hdmi1_ddc_sda */
	{I2C1_SCL, 0x50000}, /* C20 i2c1_scl.i2c1_scl */
	{I2C1_SDA, 0x50000}, /* C21 i2c1_sda.i2c1_sda */
	{GPMC_CLK, 0x50008}, /* P7 gpmc_clk.i2c3_scl */
	{GPMC_ADVN_ALE, 0x50008}, /* N1 gpmc_advn_ale.i2c3_sda */
	{GPMC_A4, 0x50007}, /* P6 gpmc_a4.i2c5_scl */
	{GPMC_A5, 0x50007}, /* R9 gpmc_a5.i2c5_sda */
	{MCASP4_FSX, 0x50004}, /* A21 mcasp4_fsx.i2c4_scl */
	{MCASP4_ACLKX, 0x50004}, /* C18 mcasp4_aclkx.i2c4_sda */
	{XREF_CLK3, 0x50004}, /* C23 xref_clk3.mcasp8_ahclkx */
	{MCASP2_AXR6, 0x50001}, /* B17 mcasp2_axr6.mcasp8_aclkx */
	{MCASP2_AXR7, 0x50001}, /* A17 mcasp2_axr7.mcasp8_fsx */
	{MCASP2_AXR4, 0x50001}, /* D15 mcasp2_axr4.mcasp8_axr0 */
	{MCASP2_AXR5, 0x50001}, /* B16 mcasp2_axr5.mcasp8_axr1 */
	{MCASP5_ACLKX, 0x50000}, /* AA3 mcasp5_aclkx.mcasp5_aclkx */
	{MCASP5_FSX, 0x50000}, /* AB9 mcasp5_fsx.mcasp5_fsx */
	{MCASP1_AXR6, 0x50001}, /* C12 mcasp1_axr6.mcasp5_axr2 */
	{MCASP1_AXR7, 0x50001}, /* D12 mcasp1_axr7.mcasp5_axr3 */
	{MMC1_CLK, 0x60000}, /* W6 mmc1_clk.mmc1_clk */
	{MMC1_CMD, 0x60000}, /* Y6 mmc1_cmd.mmc1_cmd */
	{MMC1_DAT0, 0x60000}, /* AA6 mmc1_dat0.mmc1_dat0 */
	{MMC1_DAT1, 0x60000}, /* Y4 mmc1_dat1.mmc1_dat1 */
	{MMC1_DAT2, 0x60000}, /* AA5 mmc1_dat2.mmc1_dat2 */
	{MMC1_DAT3, 0x60000}, /* Y3 mmc1_dat3.mmc1_dat3 */
	{MMC1_SDCD, 0xE0000}, /* W7 mmc1_sdcd.mmc1_sdcd */
	{GPMC_A23, 0x60001}, /* J7 gpmc_a23.mmc2_clk */
	{GPMC_CS1, 0x60001}, /* H6 gpmc_cs1.mmc2_cmd */
	{GPMC_A24, 0x60001}, /* J4 gpmc_a24.mmc2_dat0 */
	{GPMC_A25, 0x60001}, /* J6 gpmc_a25.mmc2_dat1 */
	{GPMC_A26, 0x60001}, /* H4 gpmc_a26.mmc2_dat2 */
	{GPMC_A27, 0x60001}, /* H5 gpmc_a27.mmc2_dat3 */
	{GPMC_A19, 0x60001}, /* K7 gpmc_a19.mmc2_dat4 */
	{GPMC_A20, 0x60001}, /* M7 gpmc_a20.mmc2_dat5 */
	{GPMC_A21, 0x60001}, /* J5 gpmc_a21.mmc2_dat6 */
	{GPMC_A22, 0x60001}, /* K6 gpmc_a22.mmc2_dat7 */
	{UART1_CTSN, 0x60103}, /* E25 uart1_ctsn.mmc4_clk */
	{UART1_RTSN, 0x60103}, /* C27 uart1_rtsn.mmc4_cmd */
	{UART2_RXD, 0x60103}, /* D28 uart2_rxd.mmc4_dat0 */
	{UART2_TXD, 0x60103}, /* D26 uart2_txd.mmc4_dat1 */
	{UART2_CTSN, 0x60103}, /* D27 uart2_ctsn.mmc4_dat2 */
	{UART2_RTSN, 0x60103}, /* C28 uart2_rtsn.mmc4_dat3 */
	{UART1_RXD, 0xE0003}, /* B27 uart1_rxd.mmc4_sdcd */
	{RSTOUTN, 0x10000}, /* F23 rstoutn.rstoutn */
	{RESETN, 0x50000}, /* E23 resetn.resetn */
	{XREF_CLK2, 0x50000}, /* B26 xref_clk2.xref_clk2 */
	{MCASP5_AXR1, 0x5000B}, /* AA4 mcasp5_axr1.pr2_mdio_data */
	{MCASP5_AXR0, 0x1000B}, /* AB3 mcasp5_axr0.pr2_mdio_mdclk */
	{MCASP1_AXR1, 0xD000B}, /* F12 mcasp1_axr1.pr2_mii_mt0_clk */
	{MCASP1_AXR8, 0x9000B}, /* B12 mcasp1_axr8.pr2_mii0_txen */
	{MCASP1_AXR9, 0x9000B}, /* A11 mcasp1_axr9.pr2_mii0_txd3 */
	{MCASP1_AXR10, 0x9000B}, /* B13 mcasp1_axr10.pr2_mii0_txd2 */
	{MCASP1_AXR11, 0x9000B}, /* A12 mcasp1_axr11.pr2_mii0_txd1 */
	{MCASP1_AXR12, 0x9000B}, /* E14 mcasp1_axr12.pr2_mii0_txd0 */
	{MCASP1_AXR14, 0xD000B}, /* G14 mcasp1_axr14.pr2_mii0_rxdv */
	{MCASP1_AXR13, 0xD000B}, /* A13 mcasp1_axr13.pr2_mii_mr0_clk */
	{MCASP1_AXR15, 0xD000B}, /* F14 mcasp1_axr15.pr2_mii0_rxd3 */
	{MCASP2_ACLKX, 0x5000B}, /* A19 mcasp2_aclkx.pr2_mii0_rxd2 */
	{MCASP3_ACLKX, 0x5000B}, /* B18 mcasp3_aclkx.pr2_mii0_crs */
	{MCASP1_AXR0, 0xD000B}, /* G12 mcasp1_axr0.pr2_mii0_rxer */
	{MCASP2_FSX, 0xD000B}, /* A18 mcasp2_fsx.pr2_mii0_rxd1 */
	{MCASP2_AXR2, 0xD000B}, /* C15 mcasp2_axr2.pr2_mii0_rxd0 */
	{MCASP3_FSX, 0xD000B}, /* F15 mcasp3_fsx.pr2_mii0_col */
	{MCASP2_AXR3, 0xD000B}, /* A16 mcasp2_axr3.pr2_mii0_rxlink */
	{GPIO6_10, 0x5000B}, /* AC5 gpio6_10.pr2_mii_mt1_clk */
	{GPIO6_11, 0x1000B}, /* AB4 gpio6_11.pr2_mii1_txen */
	{MMC3_CLK, 0x1000B}, /* AD4 mmc3_clk.pr2_mii1_txd3 */
	{MMC3_CMD, 0x1000B}, /* AC4 mmc3_cmd.pr2_mii1_txd2 */
	{MMC3_DAT0, 0x1000B}, /* AC7 mmc3_dat0.pr2_mii1_txd1 */
	{MMC3_DAT1, 0x1000B}, /* AC6 mmc3_dat1.pr2_mii1_txd0 */
	{MMC3_DAT3, 0x5000B}, /* AC3 mmc3_dat3.pr2_mii1_rxdv */
	{MMC3_DAT2, 0x5000B}, /* AC9 mmc3_dat2.pr2_mii_mr1_clk */
	{MMC3_DAT4, 0x5000B}, /* AC8 mmc3_dat4.pr2_mii1_rxd3 */
	{MMC3_DAT5, 0x5000B}, /* AD6 mmc3_dat5.pr2_mii1_rxd2 */
	{XREF_CLK1, 0x5000B}, /* E17 xref_clk1.pr2_mii1_crs */
	{MCASP3_AXR0, 0xD000B}, /* B19 mcasp3_axr0.pr2_mii1_rxer */
	{MMC3_DAT6, 0x5000B}, /* AB8 mmc3_dat6.pr2_mii1_rxd1 */
	{MMC3_DAT7, 0x5000B}, /* AB5 mmc3_dat7.pr2_mii1_rxd0 */
	{XREF_CLK0, 0x5000B}, /* D18 xref_clk0.pr2_mii1_col */
	{MCASP3_AXR1, 0xD000B}, /* C17 mcasp3_axr1.pr2_mii1_rxlink */
	{GPMC_A18, 0x10101}, /* R2 gpmc_a18.qspi1_sclk */
	{GPMC_A13, 0x50101}, /* R3 gpmc_a13.qspi1_rtclk */
	{GPMC_CS2, 0x20101}, /* P2 gpmc_cs2.qspi1_cs0 */
	{GPMC_A16, 0x10101}, /* U1 gpmc_a16.qspi1_d0 */
	{GPMC_A17, 0x50101}, /* P3 gpmc_a17.qspi1_d1 */
	{RTC_PORZ, 0x50000}, /* AB17 rtc_porz.rtc_porz */
	{ON_OFF, 0x10000}, /* Y11 on_off.on_off */
	{SPI1_CS1, 0x10002}, /* A22 spi1_cs1.sata1_led */
	{VOUT1_VSYNC, 0x10008}, /* E11 vout1_vsync.spi3_sclk */
	{VOUT1_HSYNC, 0x10008}, /* C11 vout1_hsync.spi3_d0 */
	{VOUT1_DE, 0x10008}, /* B10 vout1_de.spi3_d1 */
	{VOUT1_CLK, 0x20008}, /* D11 vout1_clk.spi3_cs0 */
	{VOUT1_FLD, 0x20008}, /* B11 vout1_fld.spi3_cs1 */
	{VOUT1_D0, 0x20008}, /* F11 vout1_d0.spi3_cs2 */
	{VIN2A_HSYNC0, 0x10008}, /* G1 vin2a_hsync0.spi4_sclk */
	{VIN2A_D0, 0x10008}, /* F2 vin2a_d0.spi4_d0 */
	{VIN2A_VSYNC0, 0x10008}, /* G6 vin2a_vsync0.spi4_d1 */
	{VIN2A_D1, 0x20008}, /* F3 vin2a_d1.spi4_cs0 */
	{GPMC_A12, 0x20008}, /* P4 gpmc_a12.spi4_cs1 */
	{GPMC_A14, 0x20008}, /* T2 gpmc_a14.spi4_cs3 */
	{VOUT1_D8, 0x50002}, /* E8 vout1_d8.uart6_rxd */
	{VOUT1_D9, 0x10002}, /* D9 vout1_d9.uart6_txd */
	{MCASP1_AXR2, 0x50003}, /* G13 mcasp1_axr2.uart6_ctsn */
	{MCASP1_AXR3, 0x10003}, /* J11 mcasp1_axr3.uart6_rtsn */
	{VOUT1_D16, 0x50002}, /* B7 vout1_d16.uart7_rxd */
	{VOUT1_D17, 0x10002}, /* B8 vout1_d17.uart7_txd */
	{VIN1A_HSYNC0, 0x50005}, /* AE9 vin1a_hsync0.uart7_ctsn */
	{VIN1A_VSYNC0, 0x10005}, /* AF8 vin1a_vsync0.uart7_rtsn */
	{UART3_RXD, 0xD0000}, /* V2 uart3_rxd.uart3_rxd */
	{UART3_TXD, 0x90000}, /* Y1 uart3_txd.uart3_txd */
	{MDIO_D, 0xD0001}, /* U4 mdio_d.uart3_ctsn */
	{MDIO_MCLK, 0x90001}, /* V1 mdio_mclk.uart3_rtsn */
	{GPMC_A6, 0x50007}, /* R5 gpmc_a6.uart8_rxd */
	{GPMC_A7, 0x10007}, /* P5 gpmc_a7.uart8_txd */
	{MCASP4_AXR0, 0x50003}, /* G16 mcasp4_axr0.uart8_ctsn */
	{MCASP4_AXR1, 0x10003}, /* D17 mcasp4_axr1.uart8_rtsn */
	{SPI2_D0, 0xD0002}, /* G17 spi2_d0.uart5_rxd */
	{VOUT1_D1, 0x10002}, /* G10 vout1_d1.uart5_txd */
	{GPMC_A2, 0x50008}, /* T6 gpmc_a2.uart5_ctsn */
	{GPMC_A3, 0x10008}, /* T7 gpmc_a3.uart5_rtsn */
	{USB1_DRVVBUS, 0xA0000}, /* AB10 usb1_drvvbus.usb1_drvvbus */
	{USB2_DRVVBUS, 0x90000}, /* AC10 usb2_drvvbus.usb2_drvvbus */
	{GPMC_A9, 0x90103}, /* R4 gpmc_a9.vout3_vsync */
	{GPMC_A8, 0x90103}, /* N7 gpmc_a8.vout3_hsync */
	{GPMC_CS3, 0x90103}, /* P1 gpmc_cs3.vout3_clk */
	{GPMC_A10, 0x90103}, /* N9 gpmc_a10.vout3_de */
	{GPMC_AD0, 0x90103}, /* M6 gpmc_ad0.vout3_d0 */
	{GPMC_AD1, 0x90103}, /* M2 gpmc_ad1.vout3_d1 */
	{GPMC_AD2, 0x90103}, /* L5 gpmc_ad2.vout3_d2 */
	{GPMC_AD3, 0x90103}, /* M1 gpmc_ad3.vout3_d3 */
	{GPMC_AD4, 0x90103}, /* L6 gpmc_ad4.vout3_d4 */
	{GPMC_AD5, 0x90103}, /* L4 gpmc_ad5.vout3_d5 */
	{GPMC_AD6, 0x90103}, /* L3 gpmc_ad6.vout3_d6 */
	{GPMC_AD7, 0x90103}, /* L2 gpmc_ad7.vout3_d7 */
	{GPMC_AD8, 0x90103}, /* L1 gpmc_ad8.vout3_d8 */
	{GPMC_AD9, 0x90103}, /* K2 gpmc_ad9.vout3_d9 */
	{GPMC_AD10, 0x90103}, /* J1 gpmc_ad10.vout3_d10 */
	{GPMC_AD11, 0x90103}, /* J2 gpmc_ad11.vout3_d11 */
	{GPMC_AD12, 0x90103}, /* H1 gpmc_ad12.vout3_d12 */
	{GPMC_AD13, 0x90103}, /* J3 gpmc_ad13.vout3_d13 */
	{GPMC_AD14, 0x90103}, /* H2 gpmc_ad14.vout3_d14 */
	{GPMC_AD15, 0x90103}, /* H3 gpmc_ad15.vout3_d15 */
	{GPMC_A0, 0x90103}, /* R6 gpmc_a0.vout3_d16 */
	{GPMC_A1, 0x90103}, /* T9 gpmc_a1.vout3_d17 */
};

const struct iodelay_cfg_entry iodelay_cfg_array_som_5728m[] = {
	{0x714, 139, 1081}, /* Y2 CFG_RGMII0_RXD1_IN */
	{0x720, 195, 1100}, /* V3 CFG_RGMII0_RXD2_IN */
	{0x72c, 239, 1216}, /* V4 CFG_RGMII0_RXD3_IN */
	{0x708, 123, 1047}, /* W2 CFG_RGMII0_RXD0_IN */
	{0x758, 339, 162}, /* U6 CFG_RGMII0_TXD0_OUT */
	{0x764, 146, 94}, /* V6 CFG_RGMII0_TXD1_OUT */
	{0x770, 0, 27}, /* U7 CFG_RGMII0_TXD2_OUT */
	{0x77c, 291, 205}, /* V7 CFG_RGMII0_TXD3_OUT */
	{0x740, 89, 0}, /* W9 CFG_RGMII0_TXC_OUT */
	{0x74c, 15, 125}, /* V9 CFG_RGMII0_TXCTL_OUT */
	{0x6f0, 260, 0}, /* U5 CFG_RGMII0_RXC_IN */
	{0x6fc, 0, 1412}, /* V5 CFG_RGMII0_RXCTL_IN */
	{0x840, 0, 0}, /* E25 CFG_UART1_CTSN_IN */
	{0x848, 0, 0}, /* E25 CFG_UART1_CTSN_OUT */
	{0x84c, 307, 0}, /* C27 CFG_UART1_RTSN_IN */
	{0x850, 0, 0}, /* C27 CFG_UART1_RTSN_OEN */
	{0x854, 0, 0}, /* C27 CFG_UART1_RTSN_OUT */
	{0x888, 683, 0}, /* D28 CFG_UART2_RXD_IN */
	{0x88c, 0, 0}, /* D28 CFG_UART2_RXD_OEN */
	{0x890, 0, 0}, /* D28 CFG_UART2_RXD_OUT */
	{0x894, 835, 0}, /* D26 CFG_UART2_TXD_IN */
	{0x898, 0, 0}, /* D26 CFG_UART2_TXD_OEN */
	{0x89c, 0, 0}, /* D26 CFG_UART2_TXD_OUT */
	{0x870, 785, 0}, /* D27 CFG_UART2_CTSN_IN */
	{0x874, 0, 0}, /* D27 CFG_UART2_CTSN_OEN */
	{0x878, 0, 0}, /* D27 CFG_UART2_CTSN_OUT */
	{0x87c, 613, 0}, /* C28 CFG_UART2_RTSN_IN */
	{0x880, 0, 0}, /* C28 CFG_UART2_RTSN_OEN */
	{0x884, 0, 0}, /* C28 CFG_UART2_RTSN_OUT */
	{0x30, 0, 0}, /* U3 CFG_RMII_MHZ_50_CLK_IN */
	{0x30, 0, 0}, /* U3 CFG_RMII_MHZ_50_CLK_IN */
	{0x188, 590, 0}, /* R2 CFG_GPMC_A18_OUT */
	{0x144, 0, 0}, /* R3 CFG_GPMC_A13_IN */
	{0x374, 0, 0}, /* P2 CFG_GPMC_CS2_OUT */
	{0x168, 2528, 1007}, /* U1 CFG_GPMC_A16_IN */
	{0x170, 0, 0}, /* U1 CFG_GPMC_A16_OUT */
	{0x174, 2533, 980}, /* P3 CFG_GPMC_A17_IN */
	{0x260, 998, 0}, /* R4 CFG_GPMC_A9_OUT */
	{0x254, 1843, 0}, /* N7 CFG_GPMC_A8_OUT */
	{0x380, 1505, 1379}, /* P1 CFG_GPMC_CS3_OUT */
	{0x128, 1157, 0}, /* N9 CFG_GPMC_A10_OUT */
	{0x26c, 1151, 0}, /* M6 CFG_GPMC_AD0_OUT */
	{0x2c0, 956, 0}, /* M2 CFG_GPMC_AD1_OUT */
	{0x2cc, 1222, 0}, /* L5 CFG_GPMC_AD2_OUT */
	{0x2d8, 875, 0}, /* M1 CFG_GPMC_AD3_OUT */
	{0x2e4, 1170, 0}, /* L6 CFG_GPMC_AD4_OUT */
	{0x2f0, 358, 0}, /* L4 CFG_GPMC_AD5_OUT */
	{0x2fc, 1184, 0}, /* L3 CFG_GPMC_AD6_OUT */
	{0x308, 908, 0}, /* L2 CFG_GPMC_AD7_OUT */
	{0x314, 0, 0}, /* L1 CFG_GPMC_AD8_OUT */
	{0x320, 0, 0}, /* K2 CFG_GPMC_AD9_OUT */
	{0x278, 1064, 0}, /* J1 CFG_GPMC_AD10_OUT */
	{0x284, 809, 0}, /* J2 CFG_GPMC_AD11_OUT */
	{0x290, 1161, 0}, /* H1 CFG_GPMC_AD12_OUT */
	{0x29c, 524, 0}, /* J3 CFG_GPMC_AD13_OUT */
	{0x2a8, 632, 0}, /* H2 CFG_GPMC_AD14_OUT */
	{0x2b4, 1012, 0}, /* H3 CFG_GPMC_AD15_OUT */
	{0x11c, 565, 267}, /* R6 CFG_GPMC_A0_OUT */
	{0x1a0, 650, 0}, /* T9 CFG_GPMC_A1_OUT */
};
#endif /* _MUX_DATA_EMACINC_SOM_5728M_H_ */
