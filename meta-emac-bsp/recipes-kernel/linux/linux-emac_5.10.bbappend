FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-5.10:"

COMPATIBLE_MACHINE += "somimx6|"

SRC_URI += " \
		file://defconfig \
	"
