FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-5.10:"

COMPATIBLE_MACHINE:append = "atom-sbc-64|"

SRC_URI:append = " file://defconfig "
