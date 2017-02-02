require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "standard/base"
SRCREV_machine = "6fdf2bca12625c67b64f39e08b1b4ae7c610f8bd"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.9.git;bareclone=1;branch=${KBRANCH};name=machine"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION = "4.9.4"
EMAC_LINUX_VERSION = "SL409-XKN"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
