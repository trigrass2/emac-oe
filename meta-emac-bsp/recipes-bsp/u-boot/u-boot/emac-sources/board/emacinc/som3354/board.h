/*
 * board.h
 *
 * SOM-3354 boards information header
 *
 * Copyright (C) 2015, EMAC Inc. - http://www.emacinc.com/
 *
 * SPDX-License-Identifier:	GPL-2.0+
 */

#ifndef _BOARD_H_
#define _BOARD_H_

#define EMIF_OCP_CONFIG_BEAGLEBONE_BLACK       0x00141414

/*
 * We have three pin mux functions that must exist.  We must be able to enable
 * uart0, for initial output and i2c0 to read the main EEPROM.  We then have a
 * main pinmux function that can be overridden to enable all other pinmux that
 * is required on the board.
 */
void enable_uart0_pin_mux(void);
void enable_i2c0_pin_mux(void);
void enable_board_pin_mux(void);
#endif
