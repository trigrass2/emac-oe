FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE_append = "ipac9x25|som9x25|soma5d35|soma5d36|som9g25|som9g45"

SRC_URI += " \
	    file://defconfig \
	"
