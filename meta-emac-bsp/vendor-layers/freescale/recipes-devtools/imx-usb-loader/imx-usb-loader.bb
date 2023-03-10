DESCRIPTION = "USB & UART loader for i.MX5/6/7/8 series"
AUTHOR = "Boundary Devices"
HOMEPAGE = "https://boundarydevices.com"
LICENSE = "LGPLv2"

SRCREV = "c598fd14d674a97207a4b9f6abfbe63038287806"

SRC_URI = " \
    git://github.com/boundarydevices/imx_usb_loader.git;protocol=https \
    file://imx_usb.conf \
    file://mx6_usb_rom.conf \
    file://mx6_usb_sdp_spl.conf \
"

DEPENDS = "libusb1"

S = "${WORKDIR}/git"

do_configure:prepend(){
    cp ${WORKDIR}/imx_usb.conf          ${S}/
    cp ${WORKDIR}/mx6_usb_rom.conf      ${S}/
    cp ${WORKDIR}/mx6_usb_sdp_spl.conf  ${S}/
}

do_install:append () {
    install -d ${DEPLOYDIR}/imx_usb_loader
    install ${B}/imx_usb.conf           ${DEPLOYDIR}/imx_usb_loader/
    install ${B}/mx6_usb_sdp_spl.conf   ${DEPLOYDIR}/imx_usb_loader/
    install ${B}/mx6_usb_rom.conf       ${DEPLOYDIR}/imx_usb_loader/
}

BBCLASSEXTEND:append = " \
    native \
    nativesdk \
"


# FILES:${PN}:append = " "

