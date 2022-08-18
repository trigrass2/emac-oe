DESCRIPTION = "Emac automation tools."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRC_URI = " \
    file://oe_info.sh"

FILES:${PN} += "bin/*"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/oe_info.sh ${D}${bindir}
}
