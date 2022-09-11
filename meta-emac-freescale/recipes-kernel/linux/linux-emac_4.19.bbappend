FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.19:"

COMPATIBLE_MACHINE:append = "somimx6|somimx6ul|"

SRC_URI:append = " \
	file://defconfig \
"
