DESCRIPTION = "Non-interactive ssh password auth"
HOMEPAGE = "http://sshpass.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "${SOURCEFORGE_MIRROR}/sshpass/sshpass-${PV}.tar.gz"

SRC_URI[md5sum] = "c52d65fdee0712af6f77eb2b60974ac7"
SRC_URI[sha256sum] = "c3f78752a68a0c3f62efb3332cceea0c8a1f04f7cf6b46e00ec0c3000bc8483e"

PR = "r0"

inherit autotools
