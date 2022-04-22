DESCRIPTION = "Emac serial port control tool."
AUTHOR = "EMAC Inc."
HOMEPAGE = "http://www.emacinc.com/"
LICENSE = "CLOSED"

SRCREV = "b93902d0e43957beafb4ac1244fad7460db5832b"

SRC_URI = " \
    git://git.emacinc.com/oe/serial-mode-tool.git;protocol=http;branch=master \
    file://serial-mode.conf \
"

S = "${WORKDIR}/git"

do_compile(){
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0755 serial-mode ${D}${bindir}
    install -m 0644 serial-mode.conf ${D}${sysconfdir}

    install -m 0644 ${WORKDIR}/serial-mode.conf ${D}${sysconfdir}    
}
