FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "VDX-632x-xenomai|somimx6-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"

SRC_URI_append_VDX-632x-xenomai = "file://0001-rdc.patch"
SRC_URI_append_somimx6-xenomai = "file://0001-imx6-linux-xeno.patch"

