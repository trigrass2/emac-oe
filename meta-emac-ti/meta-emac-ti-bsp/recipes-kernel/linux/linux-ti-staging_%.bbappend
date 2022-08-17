FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}/${MACHINE}:"

# SRCREV = "33574931b48f50c37abb58e0a9c617cbec472b01"
# PV = "5.10.65+git${SRCPV}"

#KERNEL_GIT_URI = "git://git.emacinc.com/linux-kernel/ti-linux-kernel.git"
#KERNEL_GIT_BRANCH = "ti-linux-5.10.y"
#KERNEL_GIT_PROTOCOL = "http"


# RDEPENDS:${KERNEL_PACKAGE_NAME}-base:remove:ti33x = " prueth-fw pruhsr-fw pruprp-fw"
# RDEPENDS_kernel-base += "kernel-image kernel-devicetree vpdma-fw goodix-fw"
# RDEPENDS_${KERNEL_PACKAGE_NAME}-base_append_som-5728 = " prueth-fw prusw-fw pruhsr-fw pruprp-fw"

KDEF = "som5728_defconfig"
KDEF:som3354 = "som3354_defconfig" 
KDEF:som3517 = "som3517_defconfig" 

SRC_URI:remove = " file://defconfig"
# 
SRC_URI:append:som5728 = " \
    file://som-5728-5228.dts \
    file://som5728-mmc-iodelay.dtsi \
    file://som-5728.dtsi \
    file://som5228_defconfig \
    file://debug_som5228_defconfig \
    file://som5728_defconfig \
"

# the som3354 does not have the pins for the PRU
SRC_URI:remove:som3354 = " file://am335x-pru-uio.dtsi"
SRC_URI:append:som3354 = " \
    file://0001-dts-makefile-som3354.patch \
    file://0002-add-lvds-panels.patch \
    file://0003-am335x-add-touchscreenreport.patch \
    \
    file://som3354_defconfig \
    \
    file://som-3354-200es.dts \
    file://som-3354-200gs.dts \
    file://som-3354-210es.dts \
    file://som-3354-212es.dts \
    file://som-3354-250es-10.dts \
    file://som-3354-250es-7.dts \
    file://som-3354-250gs-7.dts \
    file://som-3354.dtsi \
    file://som-3354-pinmux.dtsi \
"

SRC_URI:append:som3517 = " \
    file://som3517_defconfig \
    file://som-3517-210es.dts \
    file://som-3517-212es.dts \
    file://som-3517-250gs-7.dts \
    file://som-3517.dtsi \
"

do_configure() {
    cp -f ${WORKDIR}/${KDEF} ${S}/defconfig
    cp -f ${WORKDIR}/${KDEF} ${B}/defconfig
    cp -f ${WORKDIR}/${KDEF} ${S}/.config
    cp -f ${WORKDIR}/${KDEF} ${B}/.config
    cp -f ${WORKDIR}/${KDEF} ${S}/arch/arm/configs/${KDEF}
    cp -f ${WORKDIR}/${KDEF} ${B}/arch/arm/configs/${KDEF}


    cd ${S}
    oe_runmake mrproper
    cd ${B}
    oe_runmake -C ${S} O=${B} ${KDEF}
}

do_configure:prepend() {
    mkdir -p ${S}/arch/arm/boot/dts
    mkdir -p ${S}/arch/arm/configs
    mkdir -p ${B}/arch/arm/configs
}

do_configure:prepend:som5728() {
    cp -f ${WORKDIR}/som-5728-5228.dts ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-5728.dtsi ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som5728-mmc-iodelay.dtsi ${S}/arch/arm/boot/dts
}

do_configure:prepend:som3354() {
    cp -f ${WORKDIR}/som-3354-200es.dts     ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-200gs.dts     ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-210es.dts     ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-212es.dts     ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-250es-10.dts  ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-250es-7.dts   ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-250gs-7.dts   ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354.dtsi          ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3354-pinmux.dtsi   ${S}/arch/arm/boot/dts
}

do_configure:prepend::som3517() {
    cp -f ${WORKDIR}/som-3517-210es.dts    ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3517-212es.dts    ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3517-250gs-7.dts  ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-3517.dtsi         ${S}/arch/arm/boot/dts
}
