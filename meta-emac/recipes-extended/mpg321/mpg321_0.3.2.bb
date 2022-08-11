DESCRIPTION = "mpg321 is a replacement for mpg123, a very popular command-line mp3 player."
SECTION = "console/multimedia"
DEPENDS = "libmad libao"
LICENSE = "GPL"
AUTHOR = "Joe Drew <hoserhead@woot.net>"
HOMEPAGE = "http://mpg321.sourceforge.net/"

RCONFLICTS:${PN} = "mpg123"
RREPLACES:${PN} = "mpg123"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg321/mpg321_0.3.2.orig.tar.gz"
SRC_URI[md5sum] = "d3c343d2183e239e4df56a4aae2466a6"

S = "${WORKDIR}/mpg321-0.3.2-orig"

inherit autotools-brokensep

EXTRA_OECONF = "--with-ao-includes=${STAGING_INCDIR} --with-ao-libraries=${STAGING_LIBDIR}"

