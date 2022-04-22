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

## IMPORTANT If you are using qt4 and not qt5 you need to BBMASK the layer in 
## meta-emac-qt/recipies-multimedia/gstreamer-plugins-good_%.bbappend 

## OK becsaue qt4 and qt5 both use gstreamer-plugins for multimedia this extra layer is used to 
## add or remove the x11 stuff.  For further issues see
## meta-emac-qt/recipies-multimedia/gstreamer-plugins-good_%.bbappend 



PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 eglfs', 'no-opengl', d )}"
PACKAGECONFIG:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11 gdk-pixbuf', d )}"

DEPENDS:append = " \
    gstreamer1.0-plugins-base \
    libdrm \
"

RDEPENDS:${PN} += " \
    gstreamer1.0-plugins-base \
    libdrm \
"


