DESCRIPTION = "EMAC Core Package Groups"
LICENSE = "GPLv2"
PR = "r0"

inherit packagegroup

RDEPENDS_${PN} += " \
    gtk+-dev \
    linux-libc-headers-dev \
    libusb1-dev \
    confuse-dev \
    xenomai-3-dev \
    xmlrpc-c-dev \
    susi-utils-dev \
"
