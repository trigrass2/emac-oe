require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "standard/common-pc/base"
SRCREV_machine = "4434aa71ff7043c570f9eae493df1ccadbda9b85"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-3.14.git;bareclone=1;branch=${KBRANCH};name=machine"

LINUX_VERSION = "3.14.36"
LINUX_VERSION_EXTENSION ?= "-emac-standard"

PV = "${LINUX_VERSION}+git${SRCPV}"
