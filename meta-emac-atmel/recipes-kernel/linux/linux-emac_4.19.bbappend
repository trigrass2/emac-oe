FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.19:"

COMPATIBLE_MACHINE:append = "soma5d36|"

SRC_URI:append = " \
	file://defconfig \
"