DESCRIPTION = "WF111 driver and bin utils"
SECTION = "wireless driver"
LICENSE = "GPLv2"

inherit module

INSANE_SKIP_${PN}-tools = "already-stripped ldflags"

MODULES_INSTALL_TARGET = "install"

SRCREV = "71d880310d465878012ac5bb5293081bcda39992"

SRC_URI = " \
	git://github.com/morixhub/wf111-linux-driver_5.2.2-r4_armv7-a.git;branch=master \
	file://override_output_path.patch \
"
S = "${WORKDIR}/git"

export KDIR="${STAGING_KERNEL_BUILDDIR}"
export OUTPUT_BIN="${D}${sbindir}"
export OUTPUT_FIRMWARE="${D}${nonarch_base_libdir}/firmware/unifi-sdio"

PACKAGES_append = " ${PN}-fw ${PN}-tools "
FILES_${PN} = "${nonarch_base_libdir}/modules/*"
FILES_${PN}-tools = "${sbindir}"
FILES_${PN}-fw = "${nonarch_base_libdir}/firmware/*"

RPROVIDES_${PN} += "kernel-module-unifi-sdio${KERNEL_MODULE_PACKAGE_SUFFIX}"
