# Prefer libjpeg-turbo from meta-oe as it provides SIMD optimizations
PREFERRED_PROVIDER_jpeg ?= "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native ?= "libjpeg-turbo-native"

# This line is required until all of the references to libjson are changed in metadata to json-c.
PREFERRED_PROVIDER_libjson = "json-c"


PREFERRED_PROVIDER_virtual/base-utils =   "${@bb.utils.contains('EMAC_SHELLMANAGER', 'busybox', 'busybox', 'coreutils', d )}"

PREFERRED_PROVIDER_virtual/update-alternatives = "${@bb.utils.contains('EMAC_PACKAGEMANAGER', 'deb', 'dpkg', 'opkg-utils', d )}"
PREFERRED_PROVIDER_virtual/update-alternatives-native = "${@bb.utils.contains('EMAC_PACKAGEMANAGER', 'deb', 'dpkg-native', 'opkg-utils-native', d )}"


