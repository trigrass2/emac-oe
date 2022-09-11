FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-5.10:"

COMPATIBLE_MACHINE:append = "ipac9x25|"

SRC_URI:append = " file://defconfig "
