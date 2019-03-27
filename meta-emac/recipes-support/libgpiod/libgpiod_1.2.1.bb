require recipes-support/libgpiod/libgpiod.inc

DEPENDS += "autoconf-archive"

PACKAGECONFIG += "cxxbindings"

TUNE_CCARGS_armv7a = "-march=armv5e"

PACKAGECONFIG[cxxbindings] = "--enable-bindings-cxx,--disable-bindings-cxx,"

SRC_URI[md5sum] = "e6c222512a0d1994a069ebfd2e0a56fd"
SRC_URI[sha256sum] = "736d8b511ad247c2acb01b592f2bbe5e757e14e1d8347b2d80683081ab4b31b8"
