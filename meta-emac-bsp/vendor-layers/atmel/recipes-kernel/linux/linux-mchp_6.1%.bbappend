FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

inherit kernel-devicetree
KERNEL_DTC_FLAGS = "-@"

SRC_URI:append:at91sam9 = " file://defconfig"

SRC_URI:append = " \
    ${EMAC_SRC_FILES} \
"

COMPATIBLE_MACHINE:append = "|(ipac9x25|som9x25|soma5d35|soma5d36)"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}

EMAC_SRC_FILES = " \
    file://0001-out-of-tree-sources.patch \
    file://emac-sources/arch/arm/boot/dts/som9x25.dts \
    file://emac-sources/arch/arm/boot/dts/ipac9x25.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d35-bare.dtsi \
    file://emac-sources/arch/arm/boot/dts/som-a5d35.dtsi \
    file://emac-sources/arch/arm/boot/dts/som-a5d35-1xx.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d35-112es.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d35-150es.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d36.dtsi \
    file://emac-sources/arch/arm/boot/dts/som-a5d36-bare.dtsi \
    file://emac-sources/arch/arm/boot/dts/som-a5d36-2xx.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d36-200gs.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d36-212es.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d36-250gs.dts \
    file://emac-sources/arch/arm/boot/dts/som-a536m.dts \
    file://emac-sources/arch/arm/boot/dts/som-a536p.dts \
"
