FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:arm = " file://24bit_fb.patch "
