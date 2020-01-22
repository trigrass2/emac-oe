FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

COMPATIBLE_MACHINE = "somimx6|som3354|som3517|pmx|vox-150|ft10270|ft8270|pcm-3356|586|pcm-9362d|ppc-150t|pcm-9389|pcm-9375|hmi-043t|atom-sbc|atom-sbc-64|aimb-214|gene-ln05|vortex-sbc|soma5d35|soma5d36|som9g20|som9g25|som9x25|ipac9x25|som9g45"

SRC_URI += " \
		file://defconfig \
	"

SRC_URI_append_vox-150 = "file://0002-egalax.patch"
SRC_URI_append_ft10270 = "file://0002-egalax-usb.patch"
SRC_URI_append_ft8270 = "file://0002-egalax-usb.patch"
