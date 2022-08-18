
FILESEXTRAPATHS:prepend = "${THISDIR}/${PN}:${THISDIR}/${PN}/${MACHINE}"

GLES_EXTRA_DEPS = " libdrm wayland "
GLES_EXTRA_DEPS:ti33x:append = " ti-sgx-ddk-um "
PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"
PACKAGECONFIG:ti33x:append = " kms gles2 gbm "
PACKAGECONFIG_CONFARGS:ti33x:remove = "-no-eglfs"
QT_CONFIG_FLAGS += "-qpa ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', 'eglfs', d)}"

RDEPENDS:${PN} += "${PN}-conf"
