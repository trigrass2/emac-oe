DESCRIPTION = "ifplugd is a Linux daemon which will automatically configure your ethernet device \
when a cable is plugged in and automatically unconfigure it if the cable is pulled."
HOMEPAGE = "http://0pointer.de/lennart/projects/ifplugd/"
SECTION = "network"
LICENSE = "GPLv2"


SRC_URI = "file://ifplugd \
	   file://ifplugd.conf \
	   file://ifplugd.action \
	"
inherit update-rc.d

INITSCRIPT_NAME = "ifplugd"
INITSCRIPT_PARAMS = "start 41 S . stop 41 0 1 6 ."

do_install() {
	install -d ${D}${sysconfdir}/ifplugd/
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/ifplugd ${D}${sysconfdir}/init.d/ifplugd
	install -m 0644 ${WORKDIR}/ifplugd.conf ${D}${sysconfdir}/ifplugd/ifplugd.conf
	install -m 0755 ${WORKDIR}/ifplugd.action ${D}${sysconfdir}/ifplugd/ifplugd.action
}

CONFFILES_${PN} = "${sysconfdir}/ifplugd/ifplugd.conf"
