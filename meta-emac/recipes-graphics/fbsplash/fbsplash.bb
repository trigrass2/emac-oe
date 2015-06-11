DESCRIPTION = "Userspace framebuffer boot logo based on usplash"
LICENSE="CLOSED"

RESOLUTION ?= "480x272"

SRC_URI = "file://fbsplash \
           file://${RESOLUTION}_splash.conf \
           file://${RESOLUTION}_splash_image.ppm \
          "

inherit update-rc.d

INITSCRIPT_NAME = "fbsplash"
INITSCRIPT_PARAMS = "start 0 S . stop 20 0 1 6 ."

do_install() {
	install -d ${D}/mnt/.psplash/
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/splash/
	install -m 0755 ${WORKDIR}/fbsplash ${D}${sysconfdir}/init.d/fbsplash
	install -m 0644 ${WORKDIR}/${RESOLUTION}_splash.conf ${D}${sysconfdir}/splash/splash.conf
	install -m 0644 ${WORKDIR}/${RESOLUTION}_splash_image.ppm ${D}${sysconfdir}/splash/splash_image.ppm
}

FILES_${PN} += "/mnt/.psplash"
