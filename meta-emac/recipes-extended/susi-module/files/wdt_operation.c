#include "susi_watchdog.h"

ssize_t susi_wdt_read( struct file *filp, char __user *buf, size_t count, 
			loff_t *f_pos)
{
	printk(KERN_INFO "Watchdog open line num %d\n", __LINE__);
	return 0;
}
