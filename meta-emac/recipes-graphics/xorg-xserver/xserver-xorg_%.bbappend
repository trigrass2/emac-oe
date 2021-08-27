FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_arm = " file://24bit_fb.patch "
