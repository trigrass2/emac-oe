/*
 * =====================================================================================
 *
 *       Filename:  timer_test.c
 *
 *    Description:  iManager Watchdog Driver 
 *    		    MODULE NAME SusiCores, char major:85, minor = 0, 
 *
 *
 *        Version:  1.0
 *        Created:  09/12/09 22:26:00
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  wang.fei, 
 *        Company:  Advantech. xi'an
 *
 * =====================================================================================
 */

#include "susi_watchdog.h"
#include "wdtmodver.h"



static ulong	delay = 5;
module_param( delay, ulong, 0 );

MODULE_PARM_DESC( delay, "number of seconds to timer before \
							ticking: defaultv =5 ");

/* watchdog irq pass from module parameter, default =0 */
static int irq = -1;
volatile int wdt_irq = -1;
module_param( irq, int , 0);
MODULE_PARM_DESC( irq, " watchdog irq number default= -1");

int major = 85;
int minor = 0;
char modname[] = "ec1";
struct watchdog_dev	*watchdog_insts;        /* Instance of watchdog device */

static int susi_wdt_fasync( int fd, struct file *filp, int mode )
{
	return fasync_helper(fd, filp, mode, &(watchdog_insts->async_queue) );
}

static int susi_wdt_open( struct inode *inode, struct file *filp)
{
	printk(KERN_INFO "Watchdog setup timer in %s function\n", __FUNCTION__);
	
	return 0;
}

static int susi_wdt_release( struct inode *inode, struct file *filp)
{

	susi_wdt_fasync( -1, filp, 0 );
	printk( KERN_INFO " Delete Timer2\n");
	return 0;
}

extern ssize_t susi_wdt_read( struct file *filp, char __user *buf, size_t count, 
			loff_t *f_pos);

struct file_operations my_fops = {
	.owner	=	THIS_MODULE,
	.fasync	=	susi_wdt_fasync,
	.open	=	susi_wdt_open,
	.read	=	susi_wdt_read,
	.release	=     susi_wdt_release,
};


/*
 *  Note the 2.6.23 change irqreturn_t (int irq, void *dev_id, struct pt_regs *regs)
 *  to irqreturn_t (int irq, void *dev_id)
 */
#if LINUX_VERSION_CODE < KERNEL_VERSION(2, 6, 19)
static irqreturn_t wdt_isr( int irq, void *dev_id, struct pt_regs *ptregs)
#else
static irqreturn_t wdt_isr( int irq, void *dev_id)
#endif
{
	if ( watchdog_insts->async_queue )
		kill_fasync( &(watchdog_insts->async_queue), SIGIO, POLLIN);

	return IRQ_HANDLED;
}

static void watchdog_setup_cdev( struct watchdog_dev *dev)
{
	int err, devno = MKDEV( major, minor );

	cdev_init( &dev->cdev, &my_fops);
	dev->cdev.owner = THIS_MODULE;
	dev->cdev.ops	= &my_fops;

	err =  cdev_add(&dev->cdev, devno, 1);
	if ( err )
		printk( KERN_NOTICE "Error %d adding SUSI  watchdog\n", err);

	
}

 
static void susi_wdt_cleanup(void)
{

	dev_t devno = MKDEV( major ,minor );
	pr_debug("timer module cleanup\n");

	if ( watchdog_insts ) {
		cdev_del( &(watchdog_insts->cdev));
		kfree(watchdog_insts);
	}
	
	if ( wdt_irq )
		free_irq( wdt_irq, NULL);

	unregister_chrdev_region( devno, NR_DEVS );
}
module_exit(susi_wdt_cleanup);


static int __init susi_wdt_init( void )
{
	int ret = -1;
	dev_t	dev = 0;
	
	printk(KERN_INFO " Init watchdog\n");
	if ( major != 0 ) {
		dev = MKDEV( major, 0);
		ret = register_chrdev_region( dev, NR_DEVS, modname );
	} else {
		ret = alloc_chrdev_region( &dev, minor, NR_DEVS, modname );
		major = MAJOR(dev);
	}
	
	if ( ret < 0 ) {
		printk(KERN_WARNING "Watchdog: cann't got major %d\n", major);
		return ret;
	}

	watchdog_insts = kmalloc( sizeof(struct watchdog_dev), GFP_KERNEL );
	if ( !watchdog_insts ) {
		ret = -ENOMEM;
		goto fail;
	}

	memset( watchdog_insts, 0,  sizeof(struct watchdog_dev));
	watchdog_setup_cdev( watchdog_insts);
	
	printk(KERN_INFO "Watchdog: major = %d, minor = %d\n", major, minor);
	
	/* watchdog irq is pass from user space */
	wdt_irq = irq;
	if ( wdt_irq >= 0 ) {
#if LINUX_VERSION_CODE < KERNEL_VERSION( 2, 6, 19 )	
		ret = request_irq( irq, wdt_isr, SA_INTERRUPT, "wdt", NULL);
#elif LINUX_VERSION_CODE < KERNEL_VERSION(2, 6, 39)
		ret = request_irq(irq, wdt_isr, IRQ_DISABLED, "wdt", NULL);		
#else
		ret = request_irq(irq, wdt_isr, 0, "wdt", NULL);
#endif
		if ( ret ) {
			printk( KERN_INFO "Watchdog: cann't get irq %d\n", irq);
			wdt_irq = -1;
		}
	}
	return 0;
fail:
	susi_wdt_cleanup();
	return ret;
}
module_init(susi_wdt_init);
 
MODULE_DESCRIPTION("advantech SUSI watchdog driver");
MODULE_LICENSE("Adavantech");
MODULE_AUTHOR("Arhtur Wang <peter.uboot@gmail.com>");
