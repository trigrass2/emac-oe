FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://envs/${MACHINE}.txt \
    ${EMAC_SRC_FILES} \
"

UBOOT_MACHINE:ipac9x25 ?= "emac-ipac9x25_defconfig"
UBOOT_MACHINE:som9x25 ?= "emac-som9x25m_defconfig"

COMPATIBLE_MACHINE:append = "|(ipac9x25|som9x25)"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}

EMAC_SRC_FILES = " \
    file://0001-out-of-tree-sources.patch \
    \
    file://emac-sources/configs/emac-ipac9x25_defconfig \
    file://emac-sources/arch/arm/dts/ipac-9x25.dts \
    file://emac-sources/board/emacinc/ipac9x25/Kconfig \
    file://emac-sources/board/emacinc/ipac9x25/Makefile \
    file://emac-sources/include/configs/ipac9x25.h \
    file://emac-sources/board/emacinc/ipac9x25/ipac9x25.c \
    \
    file://emac-sources/configs/emac-som9x25m_defconfig \
    file://emac-sources/arch/arm/dts/som-9x25m.dts \
    file://emac-sources/board/emacinc/som9x25m/Kconfig \
    file://emac-sources/board/emacinc/som9x25m/Makefile \
    file://emac-sources/include/configs/som9x25m.h \
    file://emac-sources/board/emacinc/som9x25m/som9x25m.c \
"
