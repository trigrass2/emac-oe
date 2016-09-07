SUMMARY = "xdotool - command-line X11 automation tool - utilising X11 XTEST interface"
HOMEPAGE = "http://www.semicomplete.com/projects/xdotool"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=2f9cbf7e9401cec8a38666a08851ce6b"
SECTION = "x11"
DEPENDS = "virtual/libx11 libxtst"

PR = "r1"

inherit distro_features_check
# depends on virtual/libx11
REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/semicomplete/xdotool-${PV}.tar.gz"
SRC_URI[md5sum] = "62d0c2158bbaf882a1cf580421437b2f"
SRC_URI[sha256sum] = "e7b42c8b1d391970e1c1009b256033f30e57d8e0a2a3de229fd61ecfc27baf67"

EXTRA_OEMAKE = "PREFIX=${prefix} INSTALLLIB=${libdir} INSTALLMAN=${mandir}"

do_install() {
    oe_runmake -e install DESTDIR=${D} PREFIX=${prefix}
}

