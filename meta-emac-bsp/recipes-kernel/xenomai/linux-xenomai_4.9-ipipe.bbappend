FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "somimx6-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"
