require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "emac-4.9"
SRCREV_machine = "faf515c555ccc33f26ed06c0c873120a3f7bdb91"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.9.0"
EMAC_LINUX_VERSION = "SL409-AKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
