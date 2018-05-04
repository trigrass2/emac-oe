FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://TIInit_11.8.32.bts"
PACKAGES =+ " ${PN}-iwlwifi-4965-2 ${PN}-realtek-nic "

do_install_append() {
	install -m 0644 ${WORKDIR}/TIInit_11.8.32.bts ${D}${nonarch_base_libdir}/firmware/ti-connectivity
}

RDEPENDS_${PN}-iwlwifi-4965-2 = "${PN}-iwlwifi-license"
FILES_${PN}-iwlwifi-4965-2 = "${nonarch_base_libdir}/firmware/iwlwifi-4965-2.ucode"
FILES_${PN}-realtek-nic = "${nonarch_base_libdir}/firmware/rtl_nic/*"
