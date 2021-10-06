require linux-xenomai.inc
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-4.19.59:"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "stable/4.19.55-arm"
SRCREV = "ff9fbdc67c485809d8cef98dafaf1dc65e111e91"

SRC_URI = " \
    git://source.denx.de/Xenomai/ipipe-arm.git;branch=${KBRANCH} \
    file://0001-null-evtdev-check.patch \
    file://0002-write-once-last-tsc.patch \
"

LINUX_VERSION = "4.19.55-ipipe-arm32"

EMAC_LINUX_VERSION = "SL419-00S"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"

