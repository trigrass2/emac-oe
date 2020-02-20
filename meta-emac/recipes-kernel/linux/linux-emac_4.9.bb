require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "emac-4.9-stable"
SRCREV_machine ?= "18894c21be3eb8bc33d31c86d1b50dc3c57519c4"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "4.9.151"
EMAC_LINUX_VERSION = "SL409-00S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION_ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"
KERNEL_MODULE_PACKAGE_SUFFIX = ""
