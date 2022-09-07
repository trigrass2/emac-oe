SUMMARY = "Linux kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-5.15:"

KBRANCH = "master"
SRCREV = "8bb7eca972ad531c9b149c0a51ab43a417385813"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;branch=master \
    file://defconfig \
"

DEPENDS:append = " \
    openssl-native \
    util-linux-native \
    gmp-native \
    libmpc-native \
    zstd-native \
    ${@bb.utils.contains('ARCH', 'x86', 'elfutils-native pahole-native ', '', d)} \
"


EXTRA_OEMAKE:append = " HOSTCXX="${BUILD_CXX} ${BUILD_CXXFLAGS} ${BUILD_LDFLAGS}" "

LINUX_VERSION = "5.15.00"
PV = "${LINUX_VERSION}-git-${SRCPV}"
EMAC_LINUX_VERSION = "SL515-00S"

FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"

EMAC_LINUX_VERSION_EXTENSION:x86-64 ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}X${KERNEL_REV}.bzimg"
EMAC_LINUX_VERSION_EXTENSION:arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION:ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"

KERNEL_MODULE_PACKAGE_SUFFIX = ""
KERNEL_DEVICETREE_BUNDLE="1"

COMPATIBLE_MACHINE = "(x86-64|atom-sbc-64)"
