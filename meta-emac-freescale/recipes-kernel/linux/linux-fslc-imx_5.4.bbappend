FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-5.4:" 

SRC_URI:append = " \
    file://som350es_config \
    file://som-imx6dq.dtsi \
    file://som-imx6q-350es.dts \
    file://som-imx6q-350es-10.dts \
    file://0015_tsc2004touchscreenpropertiesfix.patch \
"
#     file://som-imx6q-350es-7.dts 

do_configure:append(){
    mkdir -p ${S}arch/arm/boot/dts
    cp -f ${WORKDIR}/som350es_config ${WORKDIR}/defconfig
    cp -f ${WORKDIR}/som350es_config ${WORKDIR}/git/defconfig
    cp -f ${WORKDIR}/som350es_config ${WORKDIR}/build/.config
    
    cp -f ${WORKDIR}/som-imx6dq.dtsi ${WORKDIR}/git/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-imx6q-350es.dts ${WORKDIR}/git/arch/arm/boot/dts
#     cp -f ${WORKDIR}/som-imx6q-350es-7.dts ${WORKDIR}/git/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-imx6q-350es-10.dts ${WORKDIR}/git/arch/arm/boot/dts
}



