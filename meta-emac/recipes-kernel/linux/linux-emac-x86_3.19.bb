require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "standard/base"
SRCREV_machine = "d5d30ba4d20e65c15df624ffce7a5cd38150348b"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-3.19.git;bareclone=1;branch=${KBRANCH};name=machine"

LINUX_VERSION = "3.19.5"
EMAC_LINUX_VERSION_EXTENSION ?= "_emac-standard"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"
