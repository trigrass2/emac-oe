DESCRIPTION = "Microchip SAM-BA In-System-Programmer"
LICENSE = "GPLv2"

inherit deploy native

SAMBA_RELEASE = "sam-ba_v3.7-linux_x86_64"

SRC_URI = " \
    https://ww1.microchip.com/downloads/aemDocuments/documents/MPU32/ProductDocuments/SoftwareLibraries/Firmware/${SAMBA_RELEASE}.tar.gz \
"
SRC_URI[sha256sum] = "d295567701914e21318f4c48ff3a57374c7c91f65f0814158e84bb07dd4d07c2"

do_compile[noexec] = "1"

FILES:${PN} = " \
    ${SAMBA_RELEASE}/* \
"

do_deploy(){
    cp -r ${WORKDIR}/${SAMBA_RELEASE} ${DEPLOYDIR}/
}
addtask deploy after do_compile