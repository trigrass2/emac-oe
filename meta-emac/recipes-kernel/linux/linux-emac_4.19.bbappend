FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.19:"

COMPATIBLE_MACHINE:append = "somimx6|somimx6ul|atom-sbc|atom-sbc-64|som3354|vortex-sbc|soma5d36|pcm-9375|"

SRC_URI:append = " \
		file://defconfig \
	"

SRC_URI:append:atom-sbc = " file://0001-egalax.patch "
