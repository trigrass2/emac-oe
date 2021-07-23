FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

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

PACKAGECONFIG_CONFARGS_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', '-syslog', '', d)}"
PACKAGECONFIG_remove = "tests"
PACKAGECONFIG_remove_somimx6q-ha = "tests examples"
PACKAGECONFIG_DEFAULT_remove_somimx6q-ha = "tests"


QT_QPA_DEFAULT_PLATFORM ??= "eglfs"
QT_QPA_EGLFS_INTEGRATION ??= ""
QT_QPA_EGLFS_INTEGRATION_somimx6q-ha ??= "eglfs_viv"

do_configure_prepend() {
    echo "QMAKE_PLATFORM          += linux" >> ${S}/mkspecs/oe-device-extra.pri
    echo "QT_QPA_DEFAULT_PLATFORM  = ${QT_QPA_DEFAULT_PLATFORM}" >> ${S}/mkspecs/oe-device-extra.pri
    if [ -n "${QT_QPA_EGLFS_INTEGRATION}" ]; then
        echo "EGLFS_DEVICE_INTEGRATION = ${QT_QPA_EGLFS_INTEGRATION}" >> ${S}/mkspecs/oe-device-extra.pri
    fi
}

# revert postinst steps from upstream recipe
pkg_postinst_${PN}-mkspecs () {
}
