DESCRIPTION = "Library for parsing configuration files."
HOMEPAGE = "http://www.nongnu.org/confuse/"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef0220292b0cce0a53f5faff0d1f102a"
SECTION = "libs"
SRC_URI = "https://github.com/martinh/libconfuse/releases/download/v3.0/confuse-${PV}.tar.gz \
"
inherit autotools binconfig pkgconfig lib_package gettext
EXTRA_OECONF = "--enable-shared"
BBCLASSEXTEND = "native"
SRC_URI[md5sum] = "bf03099ef213647451c70e54ad4b6e81"
SRC_URI[sha256sum] = "f1f326d9443103036d19c32d3f3efec3a85c3b081d99534463668d29992c4648"
