require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "emac-4.9-stable"
SRCREV_machine ?= "ba2e7c8ac97bc2a5765d67faef72d85a275f3be3"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.9.95"
EMAC_LINUX_VERSION = "SL409-00S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
KERNEL_MODULE_PACKAGE_SUFFIX = ""
