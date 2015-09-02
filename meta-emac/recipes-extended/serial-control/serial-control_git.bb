DESCRIPTION = "Emac serial port control tool."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "ddf144a850a2e1707988bf22d60c2d2477cf43bc"

SRC_URI = " \
            git://gitlab.emacinc.com/oe/serial-mode-tool.git;protocol=http \
"

S = "${WORKDIR}/git/"

do_compile(){
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0755 serial-mode ${D}${bindir}
    install -m 0644 serial-mode.conf ${D}${sysconfdir}
}
