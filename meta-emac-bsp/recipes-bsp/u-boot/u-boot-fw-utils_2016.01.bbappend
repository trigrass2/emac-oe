FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE_append = "ipac9x25|som9x25|soma5d35|soma5d36|som3354|som9g25|som9g45|somimx6|somimx6-xenomai|som3517|som9g20"

SRC_URI += " file://fw_env.config "

do_install_append () {
	install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

