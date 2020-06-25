DESCRIPTION = "EMAC Core Package Groups"
LICENSE = "GPLv2"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} += " \
    linux-libc-headers-dev \
    libusb1-dev \
    confuse-dev \
    xenomai-3-dev \
    libgpiod-dev \
    libmodbus-dev \
    boost-dev \
"
