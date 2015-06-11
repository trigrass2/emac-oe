SUMMARY = "Default Enlightenment Setup"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
SECTION = "x11"

SRC_URI = "file://gplv2-license.patch \
           file://e.tar.gz;unpack=false \
           file://ts_test.desktop \
           file://calibrate.desktop \
"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment
    install -m 0755 ${WORKDIR}/e.tar.gz ${D}${sysconfdir}/enlightenment/
    
    install -d ${D}/${datadir}/applications/
    install -m 0644 ${WORKDIR}/ts_test.desktop ${D}/${datadir}/applications/
    install -m 0644 ${WORKDIR}/calibrate.desktop ${D}/${datadir}/applications/
}
