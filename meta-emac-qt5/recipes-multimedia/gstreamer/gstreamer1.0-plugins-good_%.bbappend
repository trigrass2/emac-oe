############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
##
## Copyright (C) 2020 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
############################################################################
inherit qmake5_paths

PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 eglfs', 'no-opengl', d )}"

DEPENDS += " \
    qtbase \
    qtbase-native \
    qttools \
    qttools-native \
    qtdeclarative \
    gstreamer1.0-plugins-base \
    libdrm \
"

RDEPENDS_${PN} += " \
    qtbase \
    qtdeclarative \
    gstreamer1.0-plugins-base \
    libdrm \
"

# we have to get access to qtGui's private layers for qpa/qplatformnativeinterface.h
CXX += ' -I${STAGING_EXECPREFIXDIR}/include/qt5/QtGui/5.14.2/QtGui '

PACKAGECONFIG_remove = " x11 gdk-pixbuf "

#                       --with-moc="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/moc" 
#                       --with-uic="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/uic" 
#                       --with-rcc="${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}/rcc" 
PACKAGECONFIG_append = " qt5 "
PACKAGECONFIG[qt5] = "-Dqt5=enabled,--disable-qt,gstreamer1.0-plugins-base qtbase qtdeclarative qtbase-native"


EXTRA_OEMESON_remove = "-Dqt5=disabled"


