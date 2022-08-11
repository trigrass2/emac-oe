DESCRIPTION = "Emac automation tools."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "0617993d160bcaa994f7dc89f85e6a515238958b"
SRC_URI = " \
    git://git.emacinc.com/oe/automation-tools.git;protocol=http;branch=master \
    file://oe_info.sh"

FILES:${PN} += "emac-tools/* bin/* share/*"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${sysconfdir}/emac
    install -d ${D}${bindir}
    install -m 644 ${S}/at_board_support/oeautostart-template ${D}${sysconfdir}/emac
    install -m 755 ${S}/at_board_support/oeautostart ${D}${bindir}
    install -m 755 ${S}/at_board_support/oegdbr_b ${D}${bindir}
    install -m 755 ${S}/at_board_support/oemntrw ${D}${bindir}
    install -m 755 ${S}/at_board_support/oersplash_b ${D}${bindir}
    install -m 755 ${S}/at_board_support/oesyslog_b ${D}${bindir}
    install -m 755 ${WORKDIR}/oe_info.sh ${D}${bindir}
}

do_install:class-nativesdk() {
    install -d ${D}/bin
    install -d ${D}/share/templates
    install -d ${D}/share/man
    install -m 755 ${S}/at_host_side/bin/* ${D}/bin
    install -m 644 ${S}/at_host_side/man/* ${D}/share/man
    install -m 644 ${S}/at_host_side/share/templates/* ${D}/share/templates
}

BBCLASSEXTEND:append = " nativesdk"
