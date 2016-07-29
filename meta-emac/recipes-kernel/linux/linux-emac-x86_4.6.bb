require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "standard/base"
SRCREV_machine = "5a720e7134dd942aea147b07a1df9d736e24ed32"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.6.git;bareclone=1;branch=${KBRANCH};name=machine"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.6.1"
EMAC_LINUX_VERSION = "SL406-XKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
