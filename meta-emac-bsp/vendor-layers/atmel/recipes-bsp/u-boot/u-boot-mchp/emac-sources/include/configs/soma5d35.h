/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Configuation settings for the EMAC SoM-A5D35.
 *
 * Copyright (C) 2023 EMAC Inc.
 *
 * based on sama5d3xek.h by: 
 * Atmel
 * based on at91sam9m10g45ek.h by:
 * Stelian Pop <stelian@popies.net>
 * Lead Tech Design <www.leadtechdesign.com>
 */

/* Working interfaces:
 * 1. 10/100 RMII ethernet
 * 2. USB storage
 * 3. MMC 0 storage
 * 4. Serial Debug
*/

#ifndef __CONFIG_H
#define __CONFIG_H

#include "at91-sama5_common.h"

/*
 * This needs to be defined for the OHCI code to work but it is defined as
 * ATMEL_ID_UHPHS in the CPU specific header files.
 */
#define ATMEL_ID_UHP			32

/*
 * Specify the clock enable bit in the PMC_SCER register.
 */
#define ATMEL_PMC_UHP			(1 <<  6)

/* SDRAM */
#define CFG_SYS_SDRAM_BASE           0x20000000
#define CFG_SYS_SDRAM_SIZE		0x20000000

#endif
