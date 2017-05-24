require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-4.1.y;name=linux \
	http://xenomai.org/downloads/ipipe/v4.x/arm/ipipe-core-4.1.18-arm-9.patch \
"

SRC_URI[md5sum] = "e059063eef9f851bbb2c9b212243a389"
SRC_URI[sha256sum] = "b347b5aa296786eb76cc45da33e05f450552fd3de5d34fc45a0a322e3e9cfcff"

# tag: v4.1.18 (linux-4.1.y) 83fdace666f72dbfc4a7681a04e3689b61dae3b9
SRCREV="83fdace666f72dbfc4a7681a04e3689b61dae3b9"

LINUX_VERSION = "4.1.18-ipipe"

EMAC_LINUX_VERSION = "SL401-AKN"
PV = "${LINUX_VERSION}+git${SRCPV}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
