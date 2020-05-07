require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "emac-4.19"
SRCREV_machine ?= "e88e91b64a0cd05cc56951e0009806dfb37fa6ab"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "4.19.97"
EMAC_LINUX_VERSION = "SL419-00S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION_ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"
KERNEL_MODULE_PACKAGE_SUFFIX = ""
