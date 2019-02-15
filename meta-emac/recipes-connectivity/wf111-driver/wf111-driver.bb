DESCRIPTION = "WF111 driver and bin utils"
SECTION = "wireless driver"
LICENSE = "GPLv2"

inherit module

INSANE_SKIP_${PN} = "already-stripped"

MODULES_INSTALL_TARGET = "install"

SRC_URI = " \
	file://wf111-linux-driver-5-2-2-r3-armv7-a.tar.gz \
"
S = "${WORKDIR}/wf111-linux-driver_5.2.2-r2_armv7-a/"
export KDIR="${STAGING_KERNEL_BUILDDIR}"
export OUTPUT_BIN="${D}${sbindir}"
export OUTPUT_FIRMWARE="${D}${nonarch_base_libdir}/firmware/unifi-sdio"

PACKAGES_append = " ${PN}-fw ${PN}-tools "
FILES_${PN} = "${nonarch_base_libdir}/modules/*"
FILES_${PN}-tools = "${sbindir}"
FILES_${PN}-fw = "${nonarch_base_libdir}/firmware/*"

RPROVIDES_${PN} += "kernel-module-unifi-sdio${KERNEL_MODULE_PACKAGE_SUFFIX}"
