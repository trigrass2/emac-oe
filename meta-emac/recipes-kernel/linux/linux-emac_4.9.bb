require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "emac-4.9-stable"
SRCREV_machine ?= "4ff38b009070a1b17efb86dd651c520f5caffd8e"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.9.95"
EMAC_LINUX_VERSION = "SL409-00S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION_ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"
KERNEL_MODULE_PACKAGE_SUFFIX = ""
