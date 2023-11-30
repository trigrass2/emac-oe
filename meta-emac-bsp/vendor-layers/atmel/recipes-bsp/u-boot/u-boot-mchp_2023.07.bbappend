FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://envs/${MACHINE}.txt \
    ${EMAC_SRC_FILES} \
"

UBOOT_MACHINE:ipac9x25 ?= "emac-ipac9x25_defconfig"
UBOOT_MACHINE:som9x25 ?= "emac-som9x25m_defconfig"
UBOOT_MACHINE:soma5d35 ?= "emac-soma5d35_defconfig"
UBOOT_MACHINE:soma5d36 ?= "emac-soma5d36_defconfig"
UBOOT_MACHINE:soma536mp ?= "emac-soma536mp_defconfig"

COMPATIBLE_MACHINE:append = "|(ipac9x25|som9x25|soma5d35|soma5d36|soma536mp)"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}
do_compile:append(){
    if [ "x${SPL_BINARY}" != "x" ]
    then
        cp ${S}/spl/${SPL_BINARY} ${S}/
    fi
}

EMAC_SRC_FILES = " \
    file://0001-out-of-tree-sources.patch \
    file://emac-sources/configs/emac-ipac9x25_defconfig \
    file://emac-sources/configs/emac-som9x25m_defconfig \
    file://emac-sources/configs/emac-soma5d36_defconfig \
    file://emac-sources/configs/emac-soma536mp_defconfig \
    file://emac-sources/include/configs/ipac9x25.h \
    file://emac-sources/include/configs/soma5d36.h \
    file://emac-sources/include/configs/som9x25m.h \
    file://emac-sources/arch/arm/dts/som-a5d36-bare.dtsi \
    file://emac-sources/arch/arm/dts/som-a5d36.dts \
    file://emac-sources/arch/arm/dts/som-a536mp.dts \
    file://emac-sources/arch/arm/dts/ipac-9x25.dts \
    file://emac-sources/board/emacinc/som9x25m/Kconfig \
    file://emac-sources/board/emacinc/som9x25m/Makefile \
    file://emac-sources/board/emacinc/som9x25m/som9x25m.c \
    file://emac-sources/board/emacinc/ipac9x25/Kconfig \
    file://emac-sources/board/emacinc/ipac9x25/Makefile \
    file://emac-sources/board/emacinc/ipac9x25/ipac9x25.c \
    file://emac-sources/board/emacinc/soma5d36/Kconfig \
    file://emac-sources/board/emacinc/soma5d36/Makefile \
    file://emac-sources/board/emacinc/soma5d36/soma5d36.c \
"
