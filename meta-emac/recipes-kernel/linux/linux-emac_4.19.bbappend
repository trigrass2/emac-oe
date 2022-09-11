FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.19:"

COMPATIBLE_MACHINE:append = "atom-sbc|atom-sbc-64|vortex-sbc|pcm-9375|"

SRC_URI:append = " \
		file://defconfig \
	"

SRC_URI:append:atom-sbc = " file://0001-egalax.patch "
