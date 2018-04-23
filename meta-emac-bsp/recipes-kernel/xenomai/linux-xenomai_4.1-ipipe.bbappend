FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "somimx6-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"

SRC_URI_append_somimx6-xenomai = "file://0001-imx-xeno-dts.patch file://0002-serial-serial_core-Perform-NULL-checks-for-release-r.patch"
