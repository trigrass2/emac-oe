FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://defconfig \
	    file://syslog-startup.conf \
	"

do_install_append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/syslog-startup.conf ${D}${sysconfdir}/syslog-startup.conf
}



