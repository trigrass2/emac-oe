############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
##
## Copyright (C) 2018 The Qt Company Ltd.
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
##
############################################################################

SUMMARY = "Noto Sans CJK"
SECTION = "fonts"
HOMEPAGE = "http://www.google.com/get/noto"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=55719faa0112708e946b820b24b14097"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

PV = "1.004"
SRC_URI = "git://github.com/googlei18n/noto-cjk.git;branch=main"
SRCREV = "40d9f5b179a59a06b98373c76bdc3e2119e4e6b2"

S = "${WORKDIR}/git"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${S}/NotoSansCJKsc-Regular.otf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES:${PN}:append = " ${datadir}/fonts/otf/noto "
