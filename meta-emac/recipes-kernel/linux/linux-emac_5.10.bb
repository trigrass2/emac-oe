KBRANCH ?= "emac-5.10"
SRCREV_machine ?= "9ce2304c8f3d89ec5b0102bcc2423d2123c6cf04"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-emac.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"


# Fix missing gmp.h issues on kernel >= 5.8
DEPENDS += "gmp-native"
EXTRA_OEMAKE += " HOSTCXX="${BUILD_CXX} ${BUILD_CXXFLAGS} ${BUILD_LDFLAGS}""

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "5.10.29"
EMAC_LINUX_VERSION = "SL510-00S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION_ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"
KERNEL_MODULE_PACKAGE_SUFFIX = ""