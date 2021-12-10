KBRANCH ?= "emac-5.10"
SRCREV_machine ?= "3f1409b47bb659f9c9fce5e90cc1eb00d260cbb1"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

DEPENDS += " \
    openssl-native \
    util-linux-native \
    gmp-native \
    libmpc-native \
    zstd-native \
"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native pahole-native ', '', d)}"

EXTRA_OEMAKE += " HOSTCXX="${BUILD_CXX} ${BUILD_CXXFLAGS} ${BUILD_LDFLAGS}""

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "5.10.42"
EMAC_LINUX_VERSION = "SL510-00S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION_ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"


KERNEL_MODULE_PACKAGE_SUFFIX = ""


#kernel_do_install_x86-64_prepend(){
#    export INSTALL_MOD_STRIP=1
#}
