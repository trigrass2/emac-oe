FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-4.19:"

COMPATIBLE_MACHINE = "somimx6"

SRC_URI += " \
		file://defconfig \
	"
