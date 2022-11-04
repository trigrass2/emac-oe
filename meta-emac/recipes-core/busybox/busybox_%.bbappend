FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "\
    file://ifplugd/ifplugd \
    file://ifplugd/ifplugd.action \
    file://ifplugd/ifplugd.conf \
"

PACKAGES += " ${PN}-ifplugd "
FILES_${PN}-ifplugd = "\
    ${sysconfdir}/init.d/ifplugd \
    ${sysconfdir}/ifplugd/ifplugd.conf \
    ${sysconfdir}/ifplugd/ifplugd.action \
"

INITSCRIPT_PACKAGES += " ${PN}-ifplugd "
INITSCRIPT_NAME_${PN}-ifplugd = "ifplugd"
INITSCRIPT_PARAMS_${PN}-ifplugd = "start 41 S . stop 41 0 1 6 ."

CONFFILES_${PN}-ifplugd = "${sysconfdir}/ifplugd/ifplugd.conf"

do_install() {
    if grep -q "CONFIG_IFPLUGD=y" ${B}/.config; then
        install -d ${D}${sysconfdir}/ifplugd/
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/ifplugd/ifplugd ${D}${sysconfdir}/init.d/ifplugd
        install -m 0644 ${WORKDIR}/ifplugd/ifplugd.conf ${D}${sysconfdir}/ifplugd/ifplugd.conf
        install -m 0755 ${WORKDIR}/ifplugd/ifplugd.action ${D}${sysconfdir}/ifplugd/ifplugd.action
    fi
}