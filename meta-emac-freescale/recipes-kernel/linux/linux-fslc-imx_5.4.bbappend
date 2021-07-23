FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:" 

SRC_URI += " \
    file://defconfig_earlyprintf \
    file://som-imx6dq.dtsi \
    file://som-imx6q-350es.dts \
    file://som-imx6q-350es-10.dts \
"

do_configure_append(){
    mkdir -p ${S}arch/arm/boot/dts
    cp -f ${WORKDIR}/defconfig_earlyprintf ${WORKDIR}/defconfig
    cp -f ${WORKDIR}/defconfig_earlyprintf ${WORKDIR}/git/defconfig
    cp -f ${WORKDIR}/defconfig_earlyprintf ${WORKDIR}/build/.config
    
    cp -f ${WORKDIR}/som-imx6dq.dtsi ${WORKDIR}/git/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-imx6q-350es-10.dts ${WORKDIR}/git/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-imx6q-350es.dts ${WORKDIR}/git/arch/arm/boot/dts
}



