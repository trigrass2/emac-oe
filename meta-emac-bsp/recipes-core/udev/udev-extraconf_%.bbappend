FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_som9x25 = "file://keypad.rules"
SRC_URI_append_somA5D35 = "file://keypad.rules"

do_install_append_som9x25 () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/keypad.rules ${D}${sysconfdir}/udev/rules.d/keypad.rules
}

do_install_append_somA5D35 () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/keypad.rules ${D}${sysconfdir}/udev/rules.d/keypad.rules
}
