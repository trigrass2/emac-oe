DESCRIPTION = "WF111 driver and bin utils"
SECTION = "wireless driver"
LICENSE = "GPLv2"

inherit module

INSANE_SKIP:${PN} = "already-stripped"
INSANE_SKIP:${PN}-tools = "ldflags"

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

PACKAGES:append = " ${PN}-fw ${PN}-tools "
FILES:${PN} = "${nonarch_base_libdir}/modules/*"
FILES:${PN}-tools = "${sbindir}/*"
FILES:${PN}-fw = "${nonarch_base_libdir}/firmware/*"

RPROVIDES:${PN} += "kernel-module-unifi-sdio${KERNEL_MODULE_PACKAGE_SUFFIX}"
