SUMMARY = ""
PR = "r0"

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = " \
    ${PN} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'serial', '${PN}-serial', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'i2c', '${PN}-i2c', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'spi', '${PN}-spi', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'can', '${PN}-can', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'gpio', '${PN}-gpio', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'sound', '${PN}-sound', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'screen', '${PN}-screen', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'touchscreen', '${PN}-touch', '',d)} \
    ${PN}-network \
    ${PN}-filesystems \
"

#
# ${PN} contain stuff needed for base system (machine related)
#
RDEPENDS:${PN} = "\
    ${@bb.utils.contains('MACHINE_FEATURES', 'serial', '${PN}-serial', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'i2c', '${PN}-i2c', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'spi', '${PN}-spi', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'can', '${PN}-can', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'gpio', '${PN}-gpio', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'sound', '${PN}-sound', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'screen', '${PN}-screen', '',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'touchscreen', '${PN}-touch', '',d)} \
"
RRECOMMENDS:${PN} = " \
    ${PN}-network \
    ${PN}-filesystems \
    sysbench \
"

SUMMARY:${PN}-serial = "Serial port testing"
RDEPENDS:${PN}-serial = "\
    serialcheck \
    setserial \
    picocom \
"
SUMMARY:${PN}-i2c = "I2C testing"
RDEPENDS:${PN}-i2c = "\
    i2c-tools \
"
SUMMARY:${PN}-spi = "SPI testing"
RDEPENDS:${PN}-spi = "\
    spitools \
    spidev-test \
"
SUMMARY:${PN}-can = "CAN Bus testing"
RDEPENDS:${PN}-can = "\
    can-utils \
"
SUMMARY:${PN}-gpio = "GPIO testing"
RDEPENDS:${PN}-gpio = "\
    libgpiod-tools \
"
SUMMARY:${PN}-sound = "Sound testing"
RDEPENDS:${PN}-sound = "\
    ffmpeg \
"
SUMMARY:${PN}-screen = "Screen testing"
RDEPENDS:${PN}-screen = "\
    gstreamer1.0-meta-debug \
"
SUMMARY:${PN}-touch = "Touchscreen testing"
RDEPENDS:${PN}-touch = "\
    evtest \
"
SUMMARY:${PN}-network = "Network testing"
RDEPENDS:${PN}-network = "\
    iperf3 \
"
SUMMARY:${PN}-filesystems = "Filesystem testing (USB,MMC,MTD)"
RDEPENDS:${PN}-filesystems = "\
    fio \
"