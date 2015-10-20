require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "linux-3.10-at91"
SRCREV_machine = "99354532db3c597941d64adf1be8d8604b01ea0e"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-at91.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "3.10.0"
EMAC_LINUX_VERSION_EXTENSION ?= "-emac-standard"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"


