# FIXME if we are not using sysvinit


FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://bootlogd-add-consoles.patch"
