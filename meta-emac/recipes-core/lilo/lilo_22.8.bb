DESCRIPTION = "LiLo Bootloader"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

INSANE_SKIP_${PN} += "already-stripped"

SRC_URI = " file://lilo.conf \
	    file://lilo.conf.usb \
	    file://lilo \
	"

do_install () {
	install -d ${D}${sysconfdir}/
	install -m 644 ${WORKDIR}/lilo.conf ${D}${sysconfdir}/
	install -m 644 ${WORKDIR}/lilo.conf.usb ${D}${sysconfdir}/
	install -d ${D}${sbindir}
        install -m 755 ${WORKDIR}/lilo ${D}${sbindir}/
}

CONFFILES_${PN} += "${sysconfdir}/lilo.conf \
                    ${sysconfdir}/lilo.conf.usb"

PACKAGE_ARCH = "${MACHINE_ARCH}"
