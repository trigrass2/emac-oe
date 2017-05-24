require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-3.18.y;name=linux \
	http://xenomai.org/downloads/ipipe/v3.x/x86/ipipe-core-3.18.20-x86-8.patch \
"

# tag: v3.18.20 (linux-3.18.y) e9fd6ddcabf8695329f2462d3ece5a8442f2a8cf
SRCREV="e9fd6ddcabf8695329f2462d3ece5a8442f2a8cf"

LINUX_VERSION = "3.18.20-ipipe"

EMAC_LINUX_VERSION = "SL318-AKN"
PV = "${LINUX_VERSION}+git${SRCPV}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
