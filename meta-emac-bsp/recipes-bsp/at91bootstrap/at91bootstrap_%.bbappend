FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE_append = "ipac9x25|som9x25|somA5D35|somA5D36|som9g25|som9g45"

SRC_URI += " \
	    file://defconfig \
	"
