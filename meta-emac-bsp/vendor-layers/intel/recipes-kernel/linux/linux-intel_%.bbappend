FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " file://defconfig"

COMPATIBLE_MACHINE:append = "|(intel-core2-32|intel-corei7-64)"
