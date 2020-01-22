require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "stable/4.14.85-arm"

SRC_URI = " \
	git://gitlab.denx.de/Xenomai/ipipe-arm.git;branch=${KBRANCH};protocol=http \
	file://0001-null-evtdev-check.patch \
"

SRCREV = "35a84af5b7e3193e90ee129a91054657c02e8248"

LINUX_VERSION = "4.14.85-ipipe"

EMAC_LINUX_VERSION = "SL414-00S"
PV = "${LINUX_VERSION}+git${SRCPV}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
