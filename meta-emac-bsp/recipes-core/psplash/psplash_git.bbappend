FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

do_install_append() {
	install -d ${D}/mnt/.psplash/
}

FILES_${PN} += "/mnt/.psplash"
