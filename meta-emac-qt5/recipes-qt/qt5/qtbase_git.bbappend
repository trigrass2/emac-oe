FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}/${MACHINE}:"

SRC_URI:append = " \
    file://oe-device-extra.pri \
"

# dbus and x11 want atk
DEPENDS:append:x86-64 = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', ' at-spi2-atk ', '', d )} \
"

# arm wants gles2 and eglfs for the HA  
PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 eglfs', 'no-opengl', d )}"
PACKAGECONFIG_GL:x86-64 = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gl gles2 eglfs', 'no-opengl', d )}"

PACKAGECONFIG:append = " \
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
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'journald', '', d)} \
"

PACKAGECONFIG:append:x86-64 = " \
    sm \
    xcb \
    xkb \
    directfb \
    kms \
    gbm \
"

# PACKAGECONFIG_CONFARGS_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', '-syslog', '', d)}"
PACKAGECONFIG:remove = "tests"

do_configure:prepend(){
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
}
