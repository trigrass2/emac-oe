DESCRIPTION = "Emac serial port control tool."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "3f566e8ad31c1eb062424e09ce6c350a054dcb0a"

SRC_URI = " \
            git://git.emacinc.com/oe/serial-mode-tool.git;protocol=http \
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
