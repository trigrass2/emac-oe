FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRCREV = "c598fd14d674a97207a4b9f6abfbe63038287806"

SRC_URI:append = " \
    file://imx_usb.conf \
    file://mx6_usb_rom.conf \
    file://mx6_usb_sdp_spl.conf \
"

do_configure:prepend(){
    cp ${WORKDIR}/imx_usb.conf          ${S}/
    cp ${WORKDIR}/mx6_usb_rom.conf      ${S}/
    cp ${WORKDIR}/mx6_usb_sdp_spl.conf  ${S}/
}

inherit deploy

do_deploy(){
    tar czf ${WORKDIR}/${BPN}-${PV}_${PACKAGE_ARCH}.tar.gz -C ${B} imx_usb imx_uart *.conf
    cp ${WORKDIR}/${BPN}-${PV}_${PACKAGE_ARCH}.tar.gz ${DEPLOYDIR}/
}
addtask deploy after do_compile

# FILES:${PN}:append = " "

