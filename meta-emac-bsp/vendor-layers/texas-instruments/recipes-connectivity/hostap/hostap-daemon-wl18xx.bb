# This is a TI specific version of the hostap-daemon recipe for use with the
# wl18xx wlan and bluetooth module.

require hostap.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../COPYING;md5=292eece3f2ebbaa25608eed8464018a3"

PR:append = "e"

FILESEXTRAPATHS:append := ":${THISDIR}/hostap-daemon"

# Add TI to the end to make it clear that this is a TI customized version
# of hostap
PV = "R8.7_SP3-devel-ti+git${SRCPV}"

# Tag: R8.7_SP3
SRCREV = "ee8fbdb840d95e048f58fb62bf3b5472041b5417"
BRANCH = "upstream_25_rebase"

PROVIDES += "hostap-daemon"
RPROVIDES:${PN} += "hostap-daemon"
RREPLACES:${PN} += "hostap-daemon"
RCONFLICTS:${PN} += "hostap-daemon"
