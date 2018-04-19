FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

CFLAGS_somimx6-xenomai = "-march=armv7-a"
EXTRA_OECONF_somimx6-xenomai = "--enable-smp"
