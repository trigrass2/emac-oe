FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://modem-manager"

inherit update-rc.d

INITSCRIPT_NAME = "modem-manager"
INITSCRIPT_PARAMS = "start 47 5 ."

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/modem-manager ${D}${sysconfdir}/init.d
}

