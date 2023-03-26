/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Copyright (C) 2014 Texas Instruments Incorporated - http://www.ti.com
 *
 * Author: Felipe Balbi <balbi@ti.com>
 *
 * Based on board/ti/dra7xx/evm.c
 */
#ifndef _MUX_DATA_EMACINC_SOM_5728M_350ES_H_
#define _MUX_DATA_EMACINC_SOM_5728M_350ES_H_

#include <asm/arch/mux_dra7xx.h>

const struct pad_conf_entry core_padconf_array_essential_som_5728m_350es[] = {
	/* Non negotiable pin-muxing */
	// Sata - non muxable besides the LED
	{SPI1_CS1, (M2 | PIN_OUTPUT_PULLDOWN)},	/* M6 spi1_cs1.sata1_led */
	// MMC1
	{MMC1_CLK, (M0 | PIN_INPUT)},	/* W6 mmc1_clk.mmc1_clk */
    {MMC1_CMD, (M0 | PIN_INPUT)},	/* Y6 mmc1_cmd.mmc1_cmd */
    {MMC1_DAT0, (M0 | PIN_INPUT)},	/* AA6 mmc1_dat0.mmc1_dat0 */
    {MMC1_DAT1, (M0 | PIN_INPUT)},	/* Y4 mmc1_dat1.mmc1_dat1 */
    {MMC1_DAT2, (M0 | PIN_INPUT)},	/* AA5 mmc1_dat2.mmc1_dat2 */
    {MMC1_DAT3, (M0 | PIN_INPUT)},	/* Y3 mmc1_dat3.mmc1_dat3 */
    {MMC1_SDCD, (M0 | PIN_INPUT | SLEWCONTROL)},	/* W7 mmc1_sdcd.mmc1_sdcd */
	// USBC PORTA
	{USB1_DRVVBUS, (M0 | PIN_OUTPUT | SLEWCONTROL)},	/* AB10 usb1_drvvbus.usb1_drvvbus */

#if defined(CONFIG_DISPLAY)
	// LVDS
	{GPMC_AD0, (M3 | PIN_OUTPUT)},	/* M6 gpmc_ad0.vout3_d0 */
    {GPMC_AD1, (M3 | PIN_OUTPUT)},	/* M2 gpmc_ad1.vout3_d1 */
    {GPMC_AD2, (M3 | PIN_OUTPUT)},	/* L5 gpmc_ad2.vout3_d2 */
    {GPMC_AD3, (M3 | PIN_OUTPUT)},	/* M1 gpmc_ad3.vout3_d3 */
    {GPMC_AD4, (M3 | PIN_OUTPUT)},	/* L6 gpmc_ad4.vout3_d4 */
    {GPMC_AD5, (M3 | PIN_OUTPUT)},	/* L4 gpmc_ad5.vout3_d5 */
    {GPMC_AD6, (M3 | PIN_OUTPUT)},	/* L3 gpmc_ad6.vout3_d6 */
    {GPMC_AD7, (M3 | PIN_OUTPUT)},	/* L2 gpmc_ad7.vout3_d7 */
    {GPMC_AD8, (M3 | PIN_OUTPUT)},	/* L1 gpmc_ad8.vout3_d8 */
    {GPMC_AD9, (M3 | PIN_OUTPUT)},	/* K2 gpmc_ad9.vout3_d9 */
    {GPMC_AD10, (M3 | PIN_OUTPUT)},	/* J1 gpmc_ad10.vout3_d10 */
    {GPMC_AD11, (M3 | PIN_OUTPUT)},	/* J2 gpmc_ad11.vout3_d11 */
    {GPMC_AD12, (M3 | PIN_OUTPUT)},	/* H1 gpmc_ad12.vout3_d12 */
    {GPMC_AD13, (M3 | PIN_OUTPUT)},	/* J3 gpmc_ad13.vout3_d13 */
    {GPMC_AD14, (M3 | PIN_OUTPUT)},	/* H2 gpmc_ad14.vout3_d14 */
    {GPMC_AD15, (M3 | PIN_OUTPUT)},	/* H3 gpmc_ad15.vout3_d15 */
	{GPMC_A0, (M3 | PIN_OUTPUT)},	/* R6 gpmc_a0.vout3_d16 */
    {GPMC_A1, (M3 | PIN_OUTPUT)},	/* T9 gpmc_a1.vout3_d17 */
	{GPMC_A8, (M3 | PIN_OUTPUT)},	/* N7 gpmc_a8.vout3_hsync */
    {GPMC_A9, (M3 | PIN_OUTPUT)},	/* R4 gpmc_a9.vout3_vsync */
    {GPMC_A10, (M3 | PIN_OUTPUT)},	/* N9 gpmc_a10.vout3_de */
	{GPMC_CS3, (M3 | PIN_OUTPUT)},	/* P1 gpmc_cs3.vout3_clk */
	{MMC1_SDWP, (M14 | PIN_OUTPUT )},	/* mmc1_sdwp.gpio6_28(lvds_avdd_en) */
	{VIN1A_D0, (M14 | PIN_OUTPUT )},	/* vin1a_d0.gpio3_4(lvds_aen) */
	{VIN2A_D23, (M14 | PIN_OUTPUT )},	/* vin2a_d23.gpio4_31(backlight_en_n) */
	{VIN2A_D2, (M10 | PIN_OUTPUT )},	/* vin2a_d2.eCAP1_in_PWM1_out(backlight_pwm) */
	{GPMC_A4, (M7 | PIN_INPUT)},	/* P6 gpmc_a4.i2c5_scl */
    {GPMC_A5, (M7 | PIN_INPUT)},	/* R9 gpmc_a5.i2c5_sda */
	// HDMI
	{I2C2_SDA, (M1 | PIN_INPUT)},	/* C25 i2c2_sda.hdmi1_ddc_scl */
    {I2C2_SCL, (M1 | PIN_INPUT)},	/* F17 i2c2_scl.hdmi1_ddc_sda */
	{SPI1_CS2, (M6 | PIN_INPUT | SLEWCONTROL)},	/* B21 spi1_cs2.hdmi1_hpd */
    {SPI1_CS3, (M6 | PIN_INPUT | SLEWCONTROL)},	/* B20 spi1_cs3.hdmi1_cec */
#endif
};

#endif /* _MUX_DATA_EMACINC_SOM_5728M_350ES_H_ */
