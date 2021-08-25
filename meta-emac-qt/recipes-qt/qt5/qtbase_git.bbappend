FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/${MACHINE}:"

PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 eglfs', 'no-opengl', d )}"
PACKAGECONFIG += " \
    cups \
    fontconfig \
    getentropy \
    gif \
    glib \
    harfbuzz \
    ico \
    icu \
    libinput \
    linuxfb \
    sql-sqlite \
    tslib \
    evdev \
    libinput \
    xkbcommon \
    openssl \
    freetype \
    zlib \
    dbus \
    pcre \
    sqlite \
    gui \
    imageformats \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '', d)} \
"

# PACKAGECONFIG_CONFARGS_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', '-syslog', '', d)}"
PACKAGECONFIG_remove = "tests"
PACKAGECONFIG_remove_somimx6q-ha = "tests examples"
PACKAGECONFIG_DEFAULT_remove_somimx6q-ha = "tests"


SRC_URI += " \
     file://oe-device-extra.pri \
"

do_configure_prepend(){
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
}
