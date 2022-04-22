SUMMARY = "TrueType ver­sion of Chi­nese Ar­phic fonts"
DESCRIPTION = "This pack­age pro­vides TrueType ver­sions of the Chi­nese Ar­phic fonts for use with XeLaTeX and LuaLaTeX."
HOMEPAGE = "https://ctan.org/tex-archive/fonts/arphic-ttf"
SECTION = "x11/fonts"
LICENSE = "ARPHICPL"
LIC_FILES_CHKSUM = "file://ARPHICPL.txt;md5=4555ed88e9a72fc9562af379d07c3350"

inherit allarch fontcache

FONT_PACKAGES = "${PN}"

S = "${WORKDIR}/${BPN}"

SRC_URI = "http://mirrors.ctan.org/fonts/arphic-ttf.zip"
SRC_URI[md5sum] = "40281455105c4a3c3971356ecd5dccc4"
SRC_URI[sha256sum] = "1f2a2f979d35354f383851aa5631e38dda63f5995b309aa5da97679fd132de39"

do_install () {
        install -d ${D}${datadir}/fonts/truetype/arphic
        for i in *.ttf; do
                install -m 644 $i ${D}${datadir}/fonts/truetype/arphic
        done

        install -d ${D}${docdir}/${BPN}
        for i in *.txt; do
                install -m 644 $i ${D}${docdir}/${BPN}
        done
}

FILES:${PN} = "${datadir}/fonts"
