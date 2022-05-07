FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

GLES_EXTRA_DEPS = "libdrm wayland"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

QT_CONFIG_FLAGS += "-qpa ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', 'eglfs', d)}"

SRC_URI += "\
    file://0001-deform-Fix-how-controls-are-shown.patch \
    file://0001-qtbase-plugins-platforms-eglfs_kms-fix-compiler-erro.patch \
    file://0001-eglfs-Force-888-format-only-on-env-flag.patch \
"

RDEPENDS:${PN} += "${PN}-conf"
