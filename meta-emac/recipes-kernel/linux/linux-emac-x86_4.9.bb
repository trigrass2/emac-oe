require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "standard/base"
SRCREV_machine = "81055b89bd32414ecaf95156ce9a5fa6643e530a"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.9.git;bareclone=1;branch=${KBRANCH};name=machine"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.9.21"
EMAC_LINUX_VERSION = "SL409-XKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
