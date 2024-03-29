SUMMARY = "Init script for qtdemo"
LICENSE = "MIT"
SRC_URI = "file://qt5demo-init"
PR = "r3"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/qt5demo-init ${D}${sysconfdir}/init.d/qtdemo
}

inherit update-rc.d allarch

INITSCRIPT_NAME = "qtdemo"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
