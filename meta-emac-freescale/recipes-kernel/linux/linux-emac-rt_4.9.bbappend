FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-4.9:"

COMPATIBLE_MACHINE = "somimx6-rt|"

SRC_URI += " \
    file://defconfig \
"
