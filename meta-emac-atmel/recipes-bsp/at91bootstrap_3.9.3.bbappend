FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

COMPATIBLE_MACHINE:append = "ipac9x25|som9x25|soma5d35|soma5d36|som9g25|som9g45|som9g20"


SRC_URI:remove "file://defconfig"
SRC_URI: += " \
   file://defconfig \
"

