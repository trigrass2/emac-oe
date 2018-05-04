SUMMARY = "Qt for Embedded Linux (Qt without X11)"
PR = "r2"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	qtbase \
        qtbase-examples \
        qt5-demo-init \
        liberation-fonts \
"

