require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-4.1.y;name=linux \
	http://xenomai.org/downloads/ipipe/v4.x/arm/ipipe-core-4.1.18-arm-10.patch \
"

SRC_URI[md5sum] = "b5438f9f9f8f16c86de154e54920eef5"
SRC_URI[sha256sum] = "6758d3cb99568b89815f5d95a91a41c0af4a2f015dc87269577afff0b8360fad"

# tag: v4.1.18 (linux-4.1.y) 83fdace666f72dbfc4a7681a04e3689b61dae3b9
SRCREV="83fdace666f72dbfc4a7681a04e3689b61dae3b9"

LINUX_VERSION = "4.1.18-ipipe"

EMAC_LINUX_VERSION = "SL401-AKN"
PV = "${LINUX_VERSION}+git${SRCPV}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
