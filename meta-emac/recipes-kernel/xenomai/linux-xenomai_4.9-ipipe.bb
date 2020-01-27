require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "ipipe-4.9.y"

SRC_URI = " \
	git://gitlab.denx.de/Xenomai/ipipe.git;branch=${KBRANCH};protocol=http \
	file://0001-null-evtdev-check.patch \
"

SRCREV = "3bdd645d08c22a007dcc80b2aaa6ed0e6c24baf7"

LINUX_VERSION = "4.9.146-ipipe"

EMAC_LINUX_VERSION = "SL409-AKN"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
