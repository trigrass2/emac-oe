DESCRIPTION = "EMAC Core Package Groups"
LICENSE = "GPLv2"
PR = "r0"

inherit packagegroup

# FIXME Put this where it belongs
# INFACT remove this altogether and make a sane
# sdk recipes-core/meta file
# xenomai-3-dev

RDEPENDS_${PN} += " \
    linux-libc-headers-dev \
    libusb1-dev \
    confuse-dev \
    libgpiod-dev \
    libmodbus-dev \
    boost-dev \
"
