KBRANCH ?= "v5.10-rt"
SRCREV_machine ?= "4c057b136b69269dbcd4318dd18ff93ddef1a29b"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/rt/linux-stable-rt.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"


# Fix missing gmp.h issues on kernel >= 5.8
DEPENDS += "gmp-native"
EXTRA_OEMAKE += " HOSTCXX="${BUILD_CXX} ${BUILD_CXXFLAGS} ${BUILD_LDFLAGS}""

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "5.10.47"
EMAC_LINUX_VERSION = "SL510-01S"
FIRST_SRCREV = "${@'${SRCREV_machine}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
EMAC_LINUX_VERSION_EXTENSION_arm ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_LINUX_VERSION_EXTENSION_ipac9x25 ?= "_${EMAC_LINUX_VERSION}S${SOM_NUMBER}A${KERNEL_REV}.zimg"
KERNEL_MODULE_PACKAGE_SUFFIX = ""
