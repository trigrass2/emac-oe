FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.9:"

COMPATIBLE_MACHINE:append = "somimx6|"

SRC_URI:append = " \
	file://defconfig \
"
