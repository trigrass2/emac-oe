FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "VDX-632x-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"

SRC_URI_append_VDX-632x-xenomai = "file://0001-rdc.patch"
