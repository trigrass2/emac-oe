FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "vdx-632x-xenomai"

SRC_URI_append = " \
		file://defconfig \
	"

SRC_URI_append_vdx-632x-xenomai = "file://0001-rdc.patch file://0002-vortex86-gpio.patch"
