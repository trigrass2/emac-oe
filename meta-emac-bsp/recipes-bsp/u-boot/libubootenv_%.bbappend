FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://fw_env.config \
"

do_install:append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

PACKAGE_BEFORE_PN += "${PN}-env"
RPROVIDES:${PN}-env += "u-boot-default-env"
FILES:${PN}-env = " \
    ${sysconfdir}/fw_env.config \
"
