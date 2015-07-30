require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "som3354"
SRCREV_machine = "7dd00eeeeeb809eaee34a183e7889f4c6b36e445"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

LINUX_VERSION = "4.0.0"
LINUX_VERSION_EXTENSION ?= "-emac-${LINUX_KERNEL_TYPE}"

PV = "${LINUX_VERSION}+git${SRCREV_machine}"



