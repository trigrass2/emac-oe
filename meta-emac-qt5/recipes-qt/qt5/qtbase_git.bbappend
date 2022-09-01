FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}/${MACHINE}:${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://oe-device-extra.pri \
"

# dbus and x11 want atk
DEPENDS:append:x86-64 = " \
    ${@bb.utils.contains('EMAC_DISPLAY', 'x11', ' at-spi2-atk ', '', d )} \
"

# arm wants gles2 and eglfs for the HA  
PACKAGECONFIG_GL = "${@bb.utils.contains('EMAC_DISPLAY_HW', 'opengl', 'gles2 eglfs', 'no-opengl', d )}"
PACKAGECONFIG_GL:x86-64 = "${@bb.utils.contains('EMAC_DISPLAY_HW', 'opengl', 'gl gles2 eglfs', 'no-opengl', d )}"

PACKAGECONFIG:append = " \
    accessibility \
    cups \
    fontconfig \
    getentropy \
    glib \
    harfbuzz \
    ico \
    icu \
    linuxfb \
    sql-sqlite \
    tslib \
    xkbcommon \
    openssl \
    freetype \
    zlib \
    dbus \
    pcre \
    gif jpeg libpng \
    udev \
    libinput evdev \
    widgets \
"

PACKAGECONFIG:append:x86-64 = " \
    sm \
    xcb \
    xkb \
    directfb \
    kms \
    gbm \
"

#    ${@bb.utils.contains('EMAC_INITMANAGER', 'systemd', 'journald', '', d)} 
# PACKAGECONFIG_CONFARGS_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', '-syslog', '', d)}"

PACKAGECONFIG:remove = "tests"

do_configure:prepend(){
    install -m 0644 ${WORKDIR}/oe-device-extra.pri ${S}/mkspecs
}
