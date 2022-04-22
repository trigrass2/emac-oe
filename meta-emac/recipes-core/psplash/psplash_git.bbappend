FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# SRC_URI:append = " file://progress_option.patch "

do_install:append() {
	install -d ${D}/mnt/.psplash/
}

FILES:${PN} += "/mnt/.psplash"
