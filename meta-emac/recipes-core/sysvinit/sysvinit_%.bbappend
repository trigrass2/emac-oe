# FIXME if we are not using sysvinit


FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " file://bootlogd-add-consoles.patch "
