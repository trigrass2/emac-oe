FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = "file://serial-mode.conf"

do_install_append () {
	install -m 0644 ${WORKDIR}/serial-mode.conf ${D}${sysconfdir}
}
