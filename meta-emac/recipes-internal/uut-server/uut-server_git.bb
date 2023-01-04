DESCRIPTION = "Unit Under Test Server to be used for internal testing (future public release pending)" 
SECTION = "testing" 
LICENSE = "CLOSED" 
PR = "r0" 

DEPENDS = "python3-protobuf libadam protobuf-c-native libusb1 libgpiod"
RDEPENDS:${PN} = "libusb1 libgpiod alsa-utils-aplay alsa-utils-amixer"

SRCREV = "44804b6319a0c24ef2325d3b0c1fa5c917b3d94a"

SRC_URI = "\
    git://git@git.emacinc.com/FunctionalTest/EMAC-TPA-UUT-Server.git;protocol=ssh;branch=master \
    file://uut-server-init \
"

S = "${WORKDIR}/git"

inherit pkgconfig cmake systemd update-rc.d

INITSCRIPT_NAME = "uut-server-init"
INITSCRIPT_PARAMS = "start 99 5 ."

SYSTEMD_AUTO_ENABLE:${PN} = "disable"
SYSTEMD_SERVICE:${PN} = "\
    uut-server.service \
"

do_configure_prepend() {
  cd ${S}
  git submodule init
  git submodule update --recursive
  cd -
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 uut_server ${D}${bindir}

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/uut-server-init ${D}${sysconfdir}/init.d/
}