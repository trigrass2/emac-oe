## this is only used when building qtvirtualkeyboard.
DESCRIPTION = "Hunspell is the spell checker"
LICENSE = "GPL-2.0 & (GPL-2.0|LGPL-2.1|MPL-1.1)"
LIC_FILES_CHKSUM = " \
    file://en/license.txt;md5=686e6cb566fd6382c9fcc7a557bf4544 \
    file://ar/COPYING.txt;md5=ccafd10563b9ffba693011bf470062c6 \
"

SRC_URI = "git://github.com/libreoffice/dictionaries.git;branch=libreoffice-5-4-2"

S = "${WORKDIR}/git"

inherit bin_package

# using branch libreoffice-5.4.2 for dictionaries
SRCREV = "28016713cf482d2ac466d03e007ce91ddb8b76aa"

FILES_${PN} = "${datadir}/hunspell"

do_install() {
    install -m 0755 -d ${D}${datadir}/hunspell
    install -m 0755 ${S}/en/en_GB.dic ${D}${datadir}/hunspell
    install -m 0755 ${S}/en/en_GB.aff ${D}${datadir}/hunspell
    install -m 0755 ${S}/ar/ar.dic ${D}${datadir}/hunspell/ar_EG.dic
    install -m 0755 ${S}/ar/ar.aff ${D}${datadir}/hunspell/ar_EG.aff
}
 
