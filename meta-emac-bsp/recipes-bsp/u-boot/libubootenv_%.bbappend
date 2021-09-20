FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://fw_env.config \
"

do_install_append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

PACKAGE_BEFORE_PN += "${PN}-env"
RPROVIDES_${PN}-env += "u-boot-default-env"
FILES_${PN}-env = " \
    ${sysconfdir}/fw_env.config \
"
