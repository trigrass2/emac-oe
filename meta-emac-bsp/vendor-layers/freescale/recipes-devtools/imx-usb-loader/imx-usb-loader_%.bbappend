FILESEXTRAPATHS:prepend := "${THISDIR}/files:" 

DESCRIPTION = "USB & UART loader for i.MX5/6/7/8 series"
AUTHOR = "Boundary Devices"
HOMEPAGE = "https://boundarydevices.com"

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
