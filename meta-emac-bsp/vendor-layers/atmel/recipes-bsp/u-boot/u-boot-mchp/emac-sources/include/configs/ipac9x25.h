/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Copyright (C) 2012 Atmel Corporation
 *
 * Configuation settings for the AT91SAM9X5EK board.
 */

#ifndef __CONFIG_H__
#define __CONFIG_H__

#define DEBUG 1 // REMOVE THIS

/* ARM asynchronous clock */
#define CFG_SYS_AT91_SLOW_CLOCK	32768
#define CFG_SYS_AT91_MAIN_CLOCK	12000000	/* 12 MHz crystal */

/* SDRAM */
#define CFG_SYS_SDRAM_BASE		0x20000000
#define CFG_SYS_SDRAM_SIZE		0x08000000	/* 128 megs */

/* SPL */

#define CFG_SYS_MASTER_CLOCK		132096000
#define CFG_SYS_AT91_PLLA		0x20c73f03
#define CFG_SYS_MCKR			0x1301
#define CFG_SYS_MCKR_CSS		0x1302

#endif
