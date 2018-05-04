require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "emac-4.9-stable"

SRC_URI = " \
	git://git.emacinc.com/linux-kernel/linux-emac.git;branch=${KBRANCH};name=machine;protocol=http \
	http://xenomai.org/downloads/ipipe/v4.x/arm/ipipe-core-4.9.51-arm-4.patch \
"

SRC_URI[md5sum] = "4a0723def7614113e35b0480416f3865"
SRC_URI[sha256sum] = "99e5984ed71d9b8d3a53be70cd434e486580757a50fde5ecb7bbc5d02e7ded22"

SRCREV_machine = "70d780659d29feaae6ae1d273c95f23958aa7d01"

LINUX_VERSION = "4.9.95-ipipe"

EMAC_LINUX_VERSION = "SL409-AKN"
PV = "${LINUX_VERSION}+git${SRCPV}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
