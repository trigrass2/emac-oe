DESCRIPTION = "Userspace framebuffer boot logo based on usplash"
LICENSE="CLOSED"

RESOLUTION ?= "480x272 800x480"

SRC_URI = "file://fbsplash \
	   ${SPLASH_IMAGES} \
          "

SPLASH_IMAGES = ""

inherit update-rc.d

INITSCRIPT_NAME = "fbsplash"
INITSCRIPT_PARAMS = "start 0 S . stop 20 0 1 6 ."

python __anonymous() {
    splashfiles = d.getVar('RESOLUTION', True).split()
    strfile="file://"
    strsplash="_splash_image.ppm "
    strconf="_splash.conf"
    pkgs = []

    for res in splashfiles:
        imgfull = strfile + res + strsplash
        pkgs.append(imgfull)
        conffull = strfile + res + strconf
        pkgs.append(conffull)

    d.setVar("SPLASH_IMAGES", " ".join(pkgs))
}

do_install() {
	install -d ${D}/mnt/.psplash/
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/splash/
	install -m 0755 ${WORKDIR}/fbsplash ${D}${sysconfdir}/init.d/fbsplash

	for i in ${SPLASH_IMAGES}; do
		image=$(echo $i | awk '{ image=substr($0, 8); print image; }' )
		install -m 0644 ${WORKDIR}/${image} ${D}${sysconfdir}/splash/${image}
	done
}

FILES_${PN} += "/mnt/.psplash"

PACKAGE_ARCH = "${MACHINE_ARCH}"
