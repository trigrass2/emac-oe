FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE_append = "PMX|VOX-150|FT10270|FT8270|PCM-3356|586|PCM-9362D|PPC-150T|PCM-9389|HMI-043T|Atom-SIB|Atom-SIB-64|AIMB-214|GENE-LN05|Vortex-SIB|"

SRC_URI += " \
		file://defconfig \
	"

SRC_URI_append_PMX = "file://0001-rdc.patch"
SRC_URI_append_HMI-043T = "file://0001-rdc.patch"
SRC_URI_append_Vortex-SIB = "file://0001-rdc.patch"
SRC_URI_append_PPC-150T = "file://0001-rdc.patch"
SRC_URI_append_VOX-150 = "file://0001-rdc.patch file://0002-egalax.patch"
SRC_URI_append_FT10270 = "file://0002-egalax-usb.patch"
SRC_URI_append_FT8270 = "file://0002-egalax-usb.patch"
