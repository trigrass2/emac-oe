FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-5.10:"

COMPATIBLE_MACHINE += "somimx6|ipac9x25|"

SRC_URI += " \
		file://defconfig \
	"
