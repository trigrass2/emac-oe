FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}/${MACHINE}:"

COMPATIBLE_MACHINE:append = "ipac9x25|som9x25|soma5d35|soma5d36|soma5d36mp|som9g25|som9g45|som9g20"

SRC_URI:append = " file://defconfig "

