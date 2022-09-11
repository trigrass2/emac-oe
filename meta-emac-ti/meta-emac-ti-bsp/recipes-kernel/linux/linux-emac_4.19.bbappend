FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.19:"

COMPATIBLE_MACHINE:append = "som3354|"

SRC_URI:append = " \
	file://defconfig \
"
