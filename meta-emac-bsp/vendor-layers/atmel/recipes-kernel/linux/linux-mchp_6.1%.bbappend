FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

inherit kernel-devicetree

SRC_URI:append = " \
    ${EMAC_SRC_FILES} \
"

COMPATIBLE_MACHINE:append = "|(ipac9x25|som9x25|soma5d35|soma5d36)"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}

EMAC_SRC_FILES = " \
    file://defconfig \
    file://0001-out-of-tree-sources.patch \
    file://emac-sources/arch/arm/boot/dts/som9x25.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d36.dtsi \
    file://emac-sources/arch/arm/boot/dts/ipac9x25.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d35-112es.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d35.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d35-150es.dts \
    file://emac-sources/arch/arm/boot/dts/som-a5d36-215gs.dts \
"
