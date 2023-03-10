# Prefer libjpeg-turbo from meta-oe as it provides SIMD optimizations
PREFERRED_PROVIDER_jpeg ?= "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native ?= "libjpeg-turbo-native"

# This line is required until all of the references to libjson are changed in metadata to json-c.
PREFERRED_PROVIDER_libjson = "json-c"


PREFERRED_PROVIDER_virtual/base-utils =   "coreutils"

PREFERRED_PROVIDER_virtual/update-alternatives = "opkg-utils"

PREFERRED_PROVIDER_virtual/update-alternatives-native = "opkg-utils-native"


## run time

PREFERRED_RPROVIDER_libltdl ?= "libtool"
PREFERRED_RPROVIDER_libltdl-native ?= "libtool-native"
