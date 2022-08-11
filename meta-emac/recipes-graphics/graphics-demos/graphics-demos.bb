DESCRIPTION = "Demo Graphical Images"
LICENSE="CLOSED"

RESOLUTION ?= "480x272"

SRC_URI = "${IMAGES_SRC}"

IMAGES_SRC = ""
SPLASH_IMAGES = ""

python __anonymous() {
    splashfiles = d.getVar('RESOLUTION', True).split()
    strfile="file://"
    strsplash="_ppm.tar.gz"
    strunpack=";unpack=false "
    pkgs = []

    for res in splashfiles:
        imgfull = strfile + res + strsplash + strunpack
        pkgs.append(imgfull)

    d.setVar("IMAGES_SRC", " ".join(pkgs))

    pkgs = []
    for res in splashfiles:
        img = res + strsplash + " "
        pkgs.append(img)

    d.setVar("SPLASH_IMAGES", " ".join(pkgs))

}

do_install() {
	install -d ${D}${sysconfdir}/emac/demos
	for i in ${SPLASH_IMAGES}; do
		install -m 0755 ${WORKDIR}/${i} ${D}${sysconfdir}/emac/demos/${i}
	done
}
