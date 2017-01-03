DESCRIPTION = "Emac automation tools."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "94e360fd5f4a96f610f63d64284f1e5701607c8c"

SRC_URI = " \
            git://git.emacinc.com/oe/automation-tools.git;protocol=http \
            file://oe_info.sh \
"

S = "${WORKDIR}/git/at_board_support"

do_install() {
    install -d ${D}${sysconfdir}/emac
    install -d ${D}${bindir}
    install -m 644 oeautostart-template ${D}${sysconfdir}/emac
    install -m 755 oeautostart ${D}${bindir}
    install -m 755 oegdbr_b ${D}${bindir}
    install -m 755 oemntrw ${D}${bindir}
    install -m 755 oersplash_b ${D}${bindir}
    install -m 755 oesyslog_b ${D}${bindir}
    install -m 755 ${WORKDIR}/oe_info.sh ${D}${bindir}
}
