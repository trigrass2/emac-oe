PACKAGES =+ " ${PN}-iwlwifi-4965-2 ${PN}-realtek-nic "

RDEPENDS_${PN}-iwlwifi-4965-2 = "${PN}-iwlwifi-license"
FILES_${PN}-iwlwifi-4965-2 = "/lib/firmware/iwlwifi-4965-2.ucode"
FILES_${PN}-realtek-nic = "/lib/firmware/rtl_nic/*"
