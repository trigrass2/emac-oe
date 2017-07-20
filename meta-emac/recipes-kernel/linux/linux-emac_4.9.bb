require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "emac-4.9-stable"
SRCREV_machine ?= "c00e9478d5c1565d9d9e5db528a34b5806246c6e"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.9.24"
EMAC_LINUX_VERSION = "SL409-AKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
