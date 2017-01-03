require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "linux-3.10-at91"
SRCREV_machine = "aeacdd434390a542e26a6400f585f458db300c52"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-at91.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "3.10.0"
EMAC_LINUX_VERSION = "SL310-AKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
