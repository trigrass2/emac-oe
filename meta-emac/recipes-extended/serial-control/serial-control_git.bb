DESCRIPTION = "Emac serial port control tool."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "c34fc8cb1d83406805539b87a43903a801dc188a"

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
