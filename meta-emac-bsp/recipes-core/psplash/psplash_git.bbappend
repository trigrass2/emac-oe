FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://progress_option.patch"

do_install_append() {
	install -d ${D}/mnt/.psplash/
}

FILES_${PN} += "/mnt/.psplash"
