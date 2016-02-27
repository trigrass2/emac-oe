FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "somimx6-xenomai"

CFLAGS_somimx6-xenomai = "-march=armv7-a"
EXTRA_OECONF_somimx6-xenomai = "--enable-smp"

SRC_URI_append_somimx6-xenomai = " file://0001-imx-xeno.patch"
