FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "somimx6-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"

SRC_URI_append_somimx6-xenomai = "file://0001-imx6-linux-xeno.patch"
