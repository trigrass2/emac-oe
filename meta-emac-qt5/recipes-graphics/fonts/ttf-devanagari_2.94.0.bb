############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
##
## Copyright (C) 2016 The Qt Company Ltd.
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

SUMMARY = "Lohit Devanagari Fonts"
SECTION = "fonts"
HOMEPAGE = "https://fedorahosted.org/lohit/"
LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/lohit-devanagari-ttf-${PV}/OFL.txt;md5=7dfa0a236dc535ad2d2548e6170c4402"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "https://releases.pagure.org/lohit/lohit-devanagari-ttf-${PV}.tar.gz"

SRC_URI[md5sum] = "57527ee536a18b443cf786d4b8fd5ec8"
SRC_URI[sha256sum] = "a6618aeb1d25df46d3c22e528c38ea1d1147654e19904497a1e97f4684c55353"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/truetype/lohit
    install -m 0755 -d ${D}${sysconfdir}/fonts/conf.d/
    install -m 0644 ${WORKDIR}/lohit-devanagari-ttf-${PV}/66-lohit-devanagari.conf ${D}${sysconfdir}/fonts/conf.d/
    install -m 0644 ${WORKDIR}/lohit-devanagari-ttf-${PV}/Lohit-Devanagari.ttf ${D}${datadir}/fonts/truetype/lohit
}

PACKAGES = "${PN}"
FILES:${PN}:append = "${datadir}/fonts/truetype/lohit"
