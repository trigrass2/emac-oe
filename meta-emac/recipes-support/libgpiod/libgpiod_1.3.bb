require recipes-support/libgpiod/libgpiod.inc

DEPENDS += "autoconf-archive"

PACKAGECONFIG += "cxxbindings"

TUNE_CCARGS_armv7a = "-march=armv5e"

PACKAGECONFIG[cxxbindings] = "--enable-bindings-cxx,--disable-bindings-cxx,"

SRC_URI[md5sum] = "9f7530a5d56f070ba0af78d6ba077973"
SRC_URI[sha256sum] = "6ec837f23e8f2196e5976dec4ac81403170830075e7f33ede1394eaf67f2e962"
