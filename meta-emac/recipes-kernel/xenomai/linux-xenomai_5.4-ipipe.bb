require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "ipipe/5.4.y"

SRC_URI = " \
	git://gitlab.denx.de/Xenomai/ipipe-arm.git;branch=${KBRANCH};protocol=http \
"

SRCREV = "555a383f816bd6ff16f25005e47a066a639548cf"

LINUX_VERSION = "5.4.93-ipipe"

EMAC_LINUX_VERSION = "SL504-00S"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
