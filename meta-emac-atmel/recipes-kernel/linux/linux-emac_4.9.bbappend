FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.9:"

COMPATIBLE_MACHINE:append = "soma5d35|som9g20|som9g25|som9x25|som9g45|"

SRC_URI:append = " \
		file://defconfig \
"
