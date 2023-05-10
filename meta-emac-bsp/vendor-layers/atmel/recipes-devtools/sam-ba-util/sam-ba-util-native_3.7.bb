DESCRIPTION = "Microchip SAM-BA In-System-Programmer"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/${SAMBA_RELEASE}/LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

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
    if [ -d ${WORKDIR}/sama5d3-devices ]; then
        for device in ${WORKDIR}/sama5d3-devices/*.qml; do
            echo "$(basename -s .qml ${device}) 3.7 $(basename ${device})" >> ${WORKDIR}/${SAMBA_RELEASE}/qml/SAMBA/Device/SAMA5D3/qmldir
            cp ${device} ${WORKDIR}/${SAMBA_RELEASE}/qml/SAMBA/Device/SAMA5D3/
        done
    fi
    if [ -d ${WORKDIR}/device-metadata ]; then
        for data in ${WORKDIR}/device-metadata/*.json; do
            cp ${data} ${WORKDIR}/${SAMBA_RELEASE}/metadata/
        done
    fi
    tar czf ${WORKDIR}/${SAMBA_RELEASE}.tar.gz -C ${WORKDIR}/${SAMBA_RELEASE}/ .
    cp ${WORKDIR}/${SAMBA_RELEASE}.tar.gz ${DEPLOYDIR}/
}
addtask deploy after do_compile


# SRC_URI:append:custom-board = " 
#     file://custom.qml;subdir=sama5d3-devices 
#     file://board_custom.json;subdir=device-metadata 
# "
