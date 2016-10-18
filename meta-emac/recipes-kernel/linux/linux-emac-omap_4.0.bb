require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "som3354"
SRCREV_machine = "a63ca8e2f699b341cbed55c6a8ad7af4332529bc"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.0.0"
EMAC_LINUX_VERSION = "SL400-AKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
