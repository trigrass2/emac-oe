############################################################################
##
## Copyright (C) 2019 Luxoft Sweden AB.
## Contact: https://www.qt.io/licensing/
##
############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
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

SUMMARY = "Noto Sans Arabic"
SECTION = "fonts"
HOMEPAGE = "https://www.google.com/get/noto/"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=fce5baa9b16328f04e2afc29f6e4e882"

SRC_URI = "git://github.com/googlei18n/noto-fonts.git;protocol=https;branch=main"
SRCREV = "4bff97c612daf65d4409c9ebc26dfbd6a3d83a7e"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

S = "${WORKDIR}/git"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/otf/noto
    install -m 0644 ${S}/hinted/NotoSansArabic-Regular.ttf ${D}${datadir}/fonts/otf/noto
}

PACKAGES = "${PN}"
FILES:${PN}:append = " ${datadir}/fonts/otf/noto "
