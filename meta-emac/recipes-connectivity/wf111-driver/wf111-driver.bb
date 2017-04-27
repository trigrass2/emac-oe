DESCRIPTION = "WF111 driver and bin utils"
SECTION = "wireless driver"
LICENSE = "GPLv2"

inherit module

INSANE_SKIP_${PN} = "already-stripped"

SRC_URI = " \
	file://wf111-linux-driver-5-2-2-r3-armv7-a.tar.gz \
"
S = "${WORKDIR}/wf111-linux-driver_5.2.2-r2_armv7-a/"

do_compile () {
	unset LDFLAG
	oe_runmake KDIR=${STAGING_KERNEL_BUILDDIR}
}

do_install () {
	oe_runmake install OUTPUT=${D} KDIR=${STAGING_KERNEL_BUILDDIR}
} 

PACKAGES_append = " ${PN}-fw "
FILES_${PN} = "/usr/*"
FILES_${PN}-fw = "/lib/firmware/*"
