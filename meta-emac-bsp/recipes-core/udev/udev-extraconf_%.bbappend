FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_arm = " \
	file://keypad.rules \
	file://wifi_rename.rules \
"

do_install_append_arm () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/keypad.rules ${D}${sysconfdir}/udev/rules.d/keypad.rules
    install -m 0644 ${WORKDIR}/keypad.rules ${D}${sysconfdir}/udev/rules.d/wifi_rename.rules
}
