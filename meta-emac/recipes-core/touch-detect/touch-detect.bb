DESCRIPTION = "Simple application to monitor a tslib touchscreen device for touches for \
a given timeout."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://touch_detect.c;beginline=1;endline=15;md5=ccbd9b28c32f3070c8558f30cb67e751"

PR = "r0"
PV = "svnr${SRCREV}"

SRCREV = "183"
SRC_URI = "svn://svn.emacinc.com/public/touch_detect/;module=trunk;protocol=https \
           file://calibrate.sh \
          "

inherit update-rc.d

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "calibrate.sh"
INITSCRIPT_PARAMS_${PN} = "start 48 5 2 ."

S = "${WORKDIR}/trunk"

do_compile() {
    oe_runmake all
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 touch_detect ${D}${bindir}
    install -d ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/calibrate.sh ${D}${sysconfdir}/init.d/
}

