FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.9:"

COMPATIBLE_MACHINE:append = "pmx|vox-150|ft10270|ft8270|pcm-3356|586|pcm-9362d|ppc-150t|pcm-9389|hmi-043t|aimb-214|gene-ln05|"

SRC_URI:append = " \
		file://defconfig \
	"

SRC_URI:append:vox-150 = "file://0002-egalax.patch"
SRC_URI:append:ft10270 = "file://0002-egalax-usb.patch"
SRC_URI:append:ft8270 = "file://0002-egalax-usb.patch"
