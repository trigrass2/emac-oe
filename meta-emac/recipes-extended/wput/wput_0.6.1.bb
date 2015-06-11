DESCRIPTION = "Wput is a command-line ftp-client that looks like wget but instead of downloading, uploads files or whole directories to remote ftp-servers. "
AUTHOR = " Hagen Fritsch"
HOMEPAGE = "http://wput.sourceforge.net/"
LICENSE = "GPLv2+"
DEPENDS = "gnutls openssl"

LIC_FILES_CHKSUM = "file://COPYING;md5=18810669f13b87348459e611d31ab760"

SRC_URI = "http://sourceforge.net/projects/wput/files/wput/${PV}/wput-${PV}.tgz"

SRC_URI[md5sum] = "92b41efed4db8eb4f3443c23bf7ceecf"
SRC_URI[sha256sum] = "67125acab1d520e5d2a0429cd9cf7fc379987f30d5bbed0b0e97b92b554fcc13"

inherit gettext autotools
inherit autotools-brokensep

EXTRA_OECONF = " \
		--without-ssl \
		"

do_install() {
	install -d ${D}${bindir}
        install -m 755 wput ${D}${bindir}

} 
