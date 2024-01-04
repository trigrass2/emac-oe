/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Copyright (C) 2012 Atmel Corporation
 *
 * Configuation settings for the AT91SAM9X5EK board.
 */

#ifndef __CONFIG_H__
#define __CONFIG_H__

/* ARM asynchronous clock */
#define CFG_SYS_AT91_SLOW_CLOCK	32768
#define CFG_SYS_AT91_MAIN_CLOCK	12000000	/* 12 MHz crystal */

/* SDRAM */
#define CFG_SYS_SDRAM_BASE		0x20000000
#define CFG_SYS_SDRAM_SIZE		0x08000000	/* 128 megs */

#endif
