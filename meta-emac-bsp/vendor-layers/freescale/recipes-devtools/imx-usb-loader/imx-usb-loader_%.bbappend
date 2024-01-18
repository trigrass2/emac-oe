FILESEXTRAPATHS:prepend := "${THISDIR}/files:" 

DESCRIPTION = "USB & UART loader for i.MX5/6/7/8 series"
AUTHOR = "Boundary Devices"
HOMEPAGE = "https://boundarydevices.com"

SRCREV = "c598fd14d674a97207a4b9f6abfbe63038287806"

inherit deploy

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

do_deploy(){
    # Do nothing
    exit 0
}

do_deploy:class-native(){
    tar czf ${BPN}-native.tar.gz imx_usb imx_uart *.conf README.md
    cp ${BPN}-native.tar.gz ${DEPLOYDIR}/
}
addtask deploy after do_compile
