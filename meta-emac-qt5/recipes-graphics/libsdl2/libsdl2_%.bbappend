## this is all needed for qtgamepad
PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

## this should be moved over to meta-emac-freescale
CFLAGS:somimx6q-ha:append = " -DLINUX=1 -DEGL_API_FB=1 "
## end move this

do_install:append() {
    sed -i -e "s|${STAGING_INCDIR}|$\{includedir}|g" ${D}${libdir}/pkgconfig/sdl2.pc
}
