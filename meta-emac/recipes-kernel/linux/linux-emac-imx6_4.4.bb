require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "somimx6"
SRCREV_machine = "008047476422bd7be00546c23187d9f01849f8e6"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.4.0"
EMAC_LINUX_VERSION_EXTENSION ?= "_emac-standard"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
