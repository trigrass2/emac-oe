FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.9:"

COMPATIBLE_MACHINE:append = "som3517|"

SRC_URI:append = " \
	file://defconfig \
"
