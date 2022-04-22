inherit qmake5_paths

PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 eglfs', 'no-opengl', d )}"

DEPENDS:append = " \
    qtbase \
    qtbase-native \
    qttools \
    qttools-native \
    qtdeclarative \
    gstreamer1.0-plugins-base \
    libdrm \
"

RDEPENDS:append:${PN} = " \
    qtbase \
    qtdeclarative \
    gstreamer1.0-plugins-base \
    libdrm \
"

# we have to get access to qtGui's private layers for qpa/qplatformnativeinterface.h
CXX:append = ' -I${STAGING_EXECPREFIXDIR}/include/QtGui/5.14.2/QtGui '

PACKAGECONFIG:remove = " x11 gdk-pixbuf "

#                       --with-moc="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/moc" 
#                       --with-uic="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/uic" 
#                       --with-rcc="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/rcc" 
PACKAGECONFIG:append = " qt5 "
PACKAGECONFIG[qt5] = "-Dqt5=enabled,--disable-qt,gstreamer1.0-plugins-base qtbase qtdeclarative qtbase-native"


EXTRA_OEMESON:remove = "-Dqt5=disabled"

CXXFLAGS:append = " -DEGL_API_FB "
COMPATIBLE_MACHINE = "(mx6dl|mx6q|mx6sl|mx6sx|mx6ul|mx6ull|mx7d)"
