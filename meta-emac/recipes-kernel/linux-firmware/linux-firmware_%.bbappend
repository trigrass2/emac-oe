FILESEXTRAPATHS:prepend := "${THISDIR}/linux-firmware:"

SRC_URI:append = " \
    file://TIInit_11.8.32.bts \
    file://BCM43430A1.hcd \
    file://brcmfmac43430-sdio.txt \
"

PACKAGES:append = " ${PN}-iwlwifi-4965-2 ${PN}-realtek-nic "

do_install:append() {
	install -m 0644 ${WORKDIR}/TIInit_11.8.32.bts ${D}${nonarch_base_libdir}/firmware/ti-connectivity
	install -d ${D}${nonarch_base_libdir}/firmware/brcm
	install -m 0644 ${WORKDIR}/BCM43430A1.hcd ${D}${nonarch_base_libdir}/firmware/brcm
	install -m 0644 ${WORKDIR}/brcmfmac43430-sdio.txt ${D}${nonarch_base_libdir}/firmware/brcm
}

RDEPENDS:${PN}-iwlwifi-4965-2 = "${PN}-iwlwifi-license"
FILES:${PN}-iwlwifi-4965-2 = "${nonarch_base_libdir}/firmware/iwlwifi-4965-2.ucode"
FILES:${PN}-realtek-nic = "${nonarch_base_libdir}/firmware/rtl_nic/*"
FILES:${PN}-bcm43430 += "${nonarch_base_libdir}/firmware/brcm/BCM43430A1.hcd ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.txt"
