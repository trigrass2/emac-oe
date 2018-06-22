FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://qte.sh "

SRC_URI_append_soma5d36 = " file://atmel-color-format-force.patch "

PACKAGECONFIG_DISTRO = "tslib directfb linuxfb examples sql-sqlite eglfs libinput gles2"

do_install_append() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/qte.sh ${D}${sysconfdir}/profile.d/
}
