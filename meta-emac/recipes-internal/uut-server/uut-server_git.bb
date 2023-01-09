DESCRIPTION = "Unit Under Test Server to be used for internal testing (future public release pending)" 
SECTION = "testing" 
LICENSE = "CLOSED" 
PR = "r0" 

DEPENDS = "python3-protobuf libadam protobuf-c-native libusb1 libgpiod"
RDEPENDS:${PN} = "libusb1 libgpiod alsa-utils-aplay alsa-utils-amixer"
RDEPENDS:${PN}-dev = "${PN} protobuf-c python3-protobuf libadam-staticdev"
# add this to your conf for an sdk with dev for this
# TOOLCHAIN_TARGET_TASK:append = " libadam-staticdev" # needed for uut-server-dev
# TOOLCHAIN_HOST_TASK_append = " nativesdk-protobuf-c nativesdk-python3-protobuf" # needed for uut-server-dev

SRCREV = "36a65c68ae4100297f4a7f640ea52c6c69702aa8"

SRC_URI = "\
    git://git@git.emacinc.com/FunctionalTest/EMAC-TPA-UUT-Server.git;protocol=ssh;branch=master \
    file://uut-server-init \
"

S = "${WORKDIR}/git"

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev"


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

