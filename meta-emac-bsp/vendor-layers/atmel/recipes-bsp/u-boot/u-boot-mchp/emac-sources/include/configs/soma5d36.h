/* SPDX-License-Identifier: GPL-2.0+ */
/*
 * Configuation settings for the EMAC SoM-A5D36.
 *
 * Copyright (C) 2023 EMAC Inc.
 *
 * based on sama5d3xek.h by: 
 * Atmel
 * based on at91sam9m10g45ek.h by:
 * Stelian Pop <stelian@popies.net>
 * Lead Tech Design <www.leadtechdesign.com>
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

/* board specific (not enough SRAM) */
#define CONFIG_SAMA5D3_LCD_BASE		0x23E00000

/* SDRAM */
#define CONFIG_SYS_SDRAM_BASE       0x20000000
#define CONFIG_SYS_SDRAM_SIZE		0x20000000

/* USB */
#ifdef CONFIG_CMD_USB
#define CONFIG_USB_ATMEL_CLK_SEL_UPLL
#define CONFIG_USB_OHCI_NEW
#define CONFIG_SYS_USB_OHCI_CPU_INIT
#define CONFIG_SYS_USB_OHCI_REGS_BASE		ATMEL_BASE_OHCI
#define CONFIG_SYS_USB_OHCI_SLOT_NAME		"sama5d3"
#define CONFIG_SYS_USB_OHCI_MAX_ROOT_PORTS	3
#endif

/* SPL */
#ifdef CONFIG_SD_BOOT
#define CONFIG_SPL_FS_LOAD_PAYLOAD_NAME	"u-boot.img"
#endif

#endif
