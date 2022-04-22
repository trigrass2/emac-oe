FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}-5.4:"

SRC_URI:append = " \
    file://defconfig \
"
