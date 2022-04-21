FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

COMPATIBLE_MACHINE = "somimx6-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"
