KBRANCH ?= "emac-4.9-stable-rt"
SRCREV_machine ?= "5a2e9482789a2992bf1b522d91982aa0515b6083"

inherit concatdtbs

require recipes-kernel/linux/linux-yocto.inc

PROVIDES += "virtual/kernel kernel-modules"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "4.9.84-rt"
EMAC_LINUX_VERSION = "SL409-01S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
KERNEL_MODULE_PACKAGE_SUFFIX = ""
