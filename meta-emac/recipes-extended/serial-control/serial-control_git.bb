DESCRIPTION = "Emac serial port control tool."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "25a3de66eef921f3c20e77f28c9a4635dd864e7f"

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
