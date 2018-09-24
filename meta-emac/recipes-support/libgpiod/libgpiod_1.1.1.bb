require recipes-support/libgpiod/libgpiod.inc

DEPENDS += "autoconf-archive"

PACKAGECONFIG += "cxxbindings"

PACKAGECONFIG[cxxbindings] = "--enable-bindings-cxx,--disable-bindings-cxx,"

SRC_URI[md5sum] = "e5e946cb01a35e5046a1a7a108d6a96d"
SRC_URI[sha256sum] = "172fa1544ecb51f37533b3e67862298d50c0a5cc84975f3c0706dc15467f0dfd"
