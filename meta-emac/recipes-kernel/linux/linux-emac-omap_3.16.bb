require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "master"
SRCREV_machine = "59ca9ee42838d0f597137cf811e47eaf42fdcb69"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;bareclone=1;branch=${KBRANCH};name=machine \
           file://omap_usb.patch \ 
           file://tsc2004.patch \
	   "

LINUX_VERSION = "3.16.1"
LINUX_KERNEL_TYPE ?= "standard"
LINUX_VERSION_EXTENSION ?= "-emac-${LINUX_KERNEL_TYPE}"

PV = "${LINUX_VERSION}+git${SRCREV_machine}"



