FILESEXTRAPATHS:prepend = "${THISDIR}/${PN}:${THISDIR}/${PN}/${MACHINE}"

GLES_EXTRA_DEPS = " libdrm wayland "

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

QT_CONFIG_FLAGS += "-qpa ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', 'eglfs', d)}"

RDEPENDS:${PN} += "${PN}-conf"


