SUMMARY = "Xenomai Intel"
DESCRIPTION = "xenomai cobolt core and drivers directly on top of kernel with ipipe. No need for xenmonai 3"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
S="${WORKDIR}/git"
require linux-xenomai.inc

# require recipes-kernel/linux/linux-yocto.inc
PROVIDES += " virtual/kernel kernel-modules "

KBRANCH = "RC/5.4.61/base/ipipe/xenomai_next"

SRC_URI = " \
	git://github.com/intel/linux-stable-xenomai.git;branch=${KBRANCH};protocol=http \
"

SRCREV = "28d1f40f5e4698d7400577165cf28199b60ee98e"

LINUX_VERSION = "5.4.61"

EMAC_LINUX_VERSION = "SL504-00S"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
