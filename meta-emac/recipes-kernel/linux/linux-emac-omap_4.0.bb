require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "som3354"
SRCREV_machine = "16c29d4da9df38f8443770a48b82de1f3269f57c"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.0.0"
EMAC_LINUX_VERSION = "SL400-AKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
