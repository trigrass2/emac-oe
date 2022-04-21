require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "ipipe/5.4.y"

SRC_URI = " \
	git://git.emacinc.com/Linux-Kernel/ipipe-arm.git;branch=${KBRANCH};protocol=http \
"

SRCREV = "ac330395bf5792ffbeb099be048bfb7d9f2886a7"
LINUX_VERSION = "5.4.119"

EMAC_LINUX_VERSION = "SL504-00S"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
