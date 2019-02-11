require recipes-support/libgpiod/libgpiod.inc

DEPENDS += "autoconf-archive"

PACKAGECONFIG += "cxxbindings"

TUNE_CCARGS_armv7a = "-march=armv5e"

PACKAGECONFIG[cxxbindings] = "--enable-bindings-cxx,--disable-bindings-cxx,"

SRC_URI[md5sum] = "34a9972f2f4e9c32fa940301301b007d"
SRC_URI[sha256sum] = "b6b9079c933f7c8524815437937dda6b795a16141bca202a9eec70ba5844b5ba"
