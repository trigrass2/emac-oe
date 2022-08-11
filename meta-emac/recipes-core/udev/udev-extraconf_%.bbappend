FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append:arm = " \
	file://keypad.rules \
	file://wifi_rename.rules \
"

do_install:append:arm () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/keypad.rules ${D}${sysconfdir}/udev/rules.d/keypad.rules
    install -m 0644 ${WORKDIR}/wifi_rename.rules ${D}${sysconfdir}/udev/rules.d/wifi_rename.rules
}
