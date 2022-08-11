FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-5.10:"

COMPATIBLE_MACHINE:append = "somimx6|ipac9x25|"

SRC_URI:append = " file://defconfig "
