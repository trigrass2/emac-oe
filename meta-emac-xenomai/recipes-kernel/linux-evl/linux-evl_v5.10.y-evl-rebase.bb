SUMMARY = "Xenomai 4"
DESCRIPTION = "kernel with real time patches for the moderen linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
S="${WORKDIR}/git"
require recipes-kernel/linux/linux-yocto.inc
PROVIDES += " virtual/kernel kernel-modules "
LINUX_VERSION = "5.10.61"

KBRANCH = "v5.10.y-evl-rebase"

SRCREV = "520d38c5f2c8f37cffac1a01e3466c0b1191776d"

SRC_URI = " \
    git://git.emacinc.com/Linux-Kernel/linux-evl.git;branch=${KBRANCH};protocol=http \
"

KERNEL_MODULE_PACKAGE_SUFFIX = ""

EMAC_LINUX_VERSION = "SL510-AKN"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
