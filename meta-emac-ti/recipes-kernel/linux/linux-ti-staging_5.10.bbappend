FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}/${MACHINE}:"
SRC_URI_remove_c03439-00 = " file://defconfig"

SRCREV = "33574931b48f50c37abb58e0a9c617cbec472b01"
PV = "5.10.65+git${SRCPV}"

#KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"

# SRC_URI = "git://git.emacinc.com/linux-kernel/ti-linux-kernel.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"
#git@git.emacinc.com:Linux-Kernel/ti-linux-kernel.git

KERNEL_GIT_URI = "git://git.emacinc.com/linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_BRANCH = "ti-linux-5.10.y"
KERNEL_GIT_PROTOCOL = "http"

# RDEPENDS_kernel-base += "kernel-image kernel-devicetree vpdma-fw goodix-fw"
# RDEPENDS_${KERNEL_PACKAGE_NAME}-base_append_som-5728 = " prueth-fw prusw-fw pruhsr-fw pruprp-fw"

SRC_URI += " \
     file://som-5728-5228.dts \
     file://som5728-mmc-iodelay.dtsi \
     file://som-5728.dtsi \
     file://som5228_defconfig \
     file://debug_som5228_defconfig \
     file://ti_defconfig \
"


do_configure() {
    mkdir -p ${S}/arch/arm/boot/dts

    mkdir -p ${S}/arch/arm/configs
    mkdir -p ${B}/arch/arm/configs
    
    cp -f ${WORKDIR}/som-5728-5228.dts ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som-5728.dtsi ${S}/arch/arm/boot/dts
    cp -f ${WORKDIR}/som5728-mmc-iodelay.dtsi ${S}/arch/arm/boot/dts
    
    
    
    cp -f ${WORKDIR}/ti_defconfig ${S}/defconfig
    cp -f ${WORKDIR}/ti_defconfig ${B}/defconfig

    cp -f ${WORKDIR}/ti_defconfig ${S}/.config
    cp -f ${WORKDIR}/ti_defconfig ${B}/.config
    
    cp -f ${WORKDIR}/ti_defconfig ${S}/arch/arm/configs/ti_defconfig
    cp -f ${WORKDIR}/ti_defconfig ${B}/arch/arm/configs/ti_defconfig
    
    cd ${S}
    oe_runmake mrproper
    cd ${B}
    oe_runmake -C ${S} O=${B} ti_defconfig
    
}

