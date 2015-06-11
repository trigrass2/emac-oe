FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
		file://index.html.lighttpd \
		file://about.html \
		file://arm.html \
		file://x86.html \
		file://EMAC_LOGO.png \
	"

do_install_append () {
	install -d ${D}/www/pages/images/
	install -m 0644 ${WORKDIR}/about.html ${D}/www/pages/about.html
	install -m 0644 ${WORKDIR}/arm.html ${D}/www/pages/arm.html
	install -m 0644 ${WORKDIR}/x86.html ${D}/www/pages/x86.html
	install -m 0644 ${WORKDIR}/EMAC_LOGO.png ${D}/www/pages/images/EMAC_LOGO.png
	rmdir ${D}/www/pages/dav
}
