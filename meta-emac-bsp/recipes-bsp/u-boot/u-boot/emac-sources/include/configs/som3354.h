/*
 * som3354.h
 *
 * Copyright (C) 2015 EMAC Inc. - http://www.emacinc.com/
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation version 2.
 *
 * This program is distributed "as is" WITHOUT ANY WARRANTY of any
 * kind, whether express or implied; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

#ifndef __CONFIG_SOM3354_H
#define __CONFIG_SOM3354_H

#include <configs/ti_am335x_common.h>

#define CONFIG_SYS_CACHELINE_SIZE	64
#define CONFIG_SYS_BOOTM_LEN		(16 << 20)

#define CONFIG_MACH_TYPE		MACH_TYPE_AM335XEVM

/* Clock Defines */
#define V_OSCK				26000000  /* Clock output from T2 */
#define V_SCLK				V_OSCK

#ifndef CONFIG_SPL_BUILD
#define CONFIG_EXTRA_ENV_SETTINGS \
	"bootargs=console=ttyO0,115200 " \
		"root=/dev/mmcblk0p1 ro " \
		"rootfstype=ext4 rootwait\0" \
	"bootfile=zImage\0" \
	"loadaddr=0x82000000\0" \
	"kernelsrcaddr=0x100000\0" \
	"netargs=setenv bootargs console=ttyO0,115200 " \
		"root=/dev/nfs " \
		"rootfstype=nfs " \
		"nfsroot=${serverip}:${rootpath},${nfsopts} rw " \
		"ip=dhcp\0" \
	"netboot=echo Booting from network ...; " \
		"setenv autoload no; " \
		"dhcp; " \
		"nfs ${loadaddr} ${serverip}:${rootpath}${bootfile}; " \
		"run netargs; " \
		"bootz ${loadaddr}\0"
#endif

/* NS16550 Configuration */
#define CONFIG_SYS_NS16550_COM1		0x44e09000	/* UART0 */

/* PMIC support */
#define CONFIG_POWER_TPS65910

/*
 * USB configuration.  We enable MUSB support, both for host and for
 * gadget.  We set USB0 as peripheral and USB1 as host, based on the
 * board schematic and physical port wired to each.  Then for host we
 * add mass storage support and for gadget we add both RNDIS ethernet
 * and DFU.
 */

#define CONFIG_AM335X_USB0
#define CONFIG_AM335X_USB0_MODE	MUSB_PERIPHERAL
#define CONFIG_AM335X_USB1
#define CONFIG_AM335X_USB1_MODE MUSB_HOST

#endif	/* ! __CONFIG_SOM3354_H */
