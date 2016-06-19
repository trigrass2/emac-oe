require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "som3354"
SRCREV_machine = "f7d667247a38e544207cfe2f5a3813f8bc203abb"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.0.0"
EMAC_LINUX_VERSION = "SL400-AKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
