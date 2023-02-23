SUMMARY = "EMAC Unit Under Test Server"
DESCRIPTION = "A server utilizing protobuf messages to run designed tests and return pass/fail statistics/logs. \
* Specifically, designed to perform hardware functional tests on a unit to qualify product. \
* Useful for development and product testing. \
* Poses a security risk if installed and running, allowing for unauthorized execution of arbitrary code. \
* Use at your own risk." 
SECTION = "testing" 
LICENSE = "GPLv2" 
PR = "r0" 

DEPENDS = "python3-protobuf protobuf-c-native json-c"
DEPENDS:append:class-target = " libusb1 libgpiod "
RDEPENDS:${PN}:class-target = "libusb1 libgpiod libjson"
RDEPENDS:${PN}-dev = "${PN} protobuf-c python3-protobuf"
# add this to your conf for an sdk with dev for this
# TOOLCHAIN_HOST_TASK_append = " nativesdk-protobuf-c nativesdk-python3-protobuf" # needed for uut-server-dev

UUT_SRCREV = "15d4ca9e34cd75881578bd524bc3ab407ecda5c6"
NANOPB_SRCREV = "605b44c0e9d24e1bf8ff94abf5d863e5f7beb4e6"

SRC_URI = "\
    git://git@git.emacinc.com/OE/applications/uut-server.git;protocol=https;branch=main;rev=${UUT_SRCREV};destsuffix=git \
    git://github.com/nanopb/nanopb.git;protocol=https;branch=master;rev=${NANOPB_SRCREV};destsuffix=nanopb \
"

S = "${WORKDIR}/git"

PACKAGES = "${PN} ${PN}-client ${PN}-dbg ${PN}-dev ${PN}-sound ${PN}-screen"

do_configure_prepend() {
  export OE_NANOPB_DIR=${WORKDIR}/nanopb
  export EXTRA_OECMAKE="${EXTRA_OECMAKE}"
}

inherit pkgconfig cmake systemd update-rc.d

PACKAGECONFIG ??= "${MACHINE_FEATURES}"
PACKAGECONFIG[arm] = "-DUBOOT=1,,,u-boot-fw-utils"
PACKAGECONFIG[sound] = "-DSOUND=1,,,alsa-utils-aplay alsa-utils-amixer sound-test ${PN}-sound"
PACKAGECONFIG[screen] = "-DSCREEN=1,,,${PN}-screen"
PACKAGECONFIG[touchscreen] = "-DTOUCH=1,,,tslib,tslib-calibrate tslib-tests"
PACKAGECONFIG[rtc] = "-DRTC=1"
PACKAGECONFIG[serial] = "-DSERIAL=1,,,packagegroup-base-serial"
PACKAGECONFIG[can] = "-DCANBUS=1"

EXTRA_OECMAKE:append:class-native = " -DCLIENT_ONLY=1"

INITSCRIPT_NAME = "uut-server-init"
INITSCRIPT_PARAMS = "disable"

SYSTEMD_AUTO_ENABLE:${PN} = "disable"
SYSTEMD_SERVICE:${PN} = "\
    uut-server.service \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 uut-server ${D}${bindir}
    install -m 0755 uut-client ${D}${bindir}

    #init system support
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system/
        install -m 0644 ${S}/resources/uut-server.service ${D}${systemd_unitdir}/system/uut-server.service
    else
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${S}/resources/uut-server-init ${D}${sysconfdir}/init.d/uut-server-init
    fi

    install -d ${D}${datadir}/uut-server
    install -m 0644 ${S}/resources/1khz-30s-48k.wav ${D}${datadir}/uut-server/
    install -m 0644 ${S}/resources/tv-test-pattern-800_480.ppm ${D}${datadir}/uut-server/
}
do_install:class-native(){
    install -d ${D}${bindir}
    install -m 0755 uut-client ${D}${bindir}
}

FILES:${PN} = " \
    ${bindir}/uut-server \
    ${sysconfdir}/init.d/uut-server-init \
    ${systemd_unitdir}/system/uut-server.service \
"

FILES:${PN}-client = " \
    ${bindir}/uut-client \
"

FILES:${PN}-sound = " \
    ${datadir}/uut-server/1khz-30s-48k.wav \
"

FILES:${PN}-screen = " \
    ${datadir}/uut-server/tv-test-pattern-800_480.ppm \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BBCLASSEXTEND = "native nativesdk"
