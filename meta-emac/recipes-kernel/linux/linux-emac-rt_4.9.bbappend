FILESEXTRAPATHS:prepend := "${THISDIR}/${BP}:"

COMPATIBLE_MACHINE = "somimx6-rt|"

SRC_URI += " \
		file://defconfig \
	"
