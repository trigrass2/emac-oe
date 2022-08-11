FILESEXTRAPATHS:prepend := "${THISDIR}/${BP}:"

COMPATIBLE_MACHINE = "somimx6-xenomai"

SRC_URI:append = " \
		file://defconfig \
	"
