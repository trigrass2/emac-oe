
/*
 * =====================================================================================
 *
 *       Filename:  susi_watchdog.h
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  12/14/2009 01:58:16 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *        Company:  
 *
 * =====================================================================================
 */
#define	DEBUG			/*  */
#define	pf_fmt( fmt )	"timer_test: "	fmt			/*  */


#include	<linux/kernel.h>
#include	<linux/module.h>
#include	<linux/timer.h>
#include	<linux/types.h>

#include <linux/init.h>
#include <linux/module.h>
#include <linux/version.h>
#include <linux/types.h>
#include <linux/errno.h>
#include <linux/kernel.h>
#include <linux/delay.h>
#include <linux/interrupt.h>
#include <linux/ioport.h>
#include <linux/ioctl.h>
#include <asm/io.h>
#include <linux/pci.h>
#include <linux/poll.h>
#include <linux/wait.h>
#include <linux/completion.h>
#include <linux/sched.h>
#include <linux/param.h>		
#include <linux/fs.h>
#include <asm/uaccess.h>
#include <linux/cdev.h>


#include	<linux/mc146818rtc.h>
#include	<linux/interrupt.h>
/*
 *  watchdog device 
 */
#ifndef	__WDT_SUSI
#define	__WDT_SUSI			/*  */

#ifndef	KERNEL_VERSION
#define	KERNEL_VERSION(a, b, c)	(((a) << 16) +((b) << 8) + (c))
#endif
struct watchdog_dev {
	struct	fasync_struct *async_queue;     /* asynchronous I/O */
	struct	cdev	cdev;
}__attribute__((packed()));

extern struct watchdog_dev	*watchdog_insts;


#define	NR_DEVS 1			/*  */

#endif
