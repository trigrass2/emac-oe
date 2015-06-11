DESCRIPTION = "Demo Graphical Images"
LICENSE="CLOSED"

RESOLUTION ?= "480x272"

SRC_URI = "file://${RESOLUTION}_ppm.tar.gz;unpack=false"

do_install() {
	install -d ${D}${sysconfdir}/emac/demos
	install -m 0755 ${WORKDIR}/${RESOLUTION}_ppm.tar.gz ${D}${sysconfdir}/emac/demos/graphics_ppm.tar.gz
}
