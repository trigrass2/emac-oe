DESCRIPTION = "Demo Audio Files"
LICENSE="CLOSED"

SRC_URI = "file://audio_demos.tar.gz;unpack=false"

do_install() {
	install -d ${D}${sysconfdir}/emac/demos
	install -m 0755 ${WORKDIR}/audio_demos.tar.gz ${D}${sysconfdir}/emac/demos/audio_demos.tar.gz
}
