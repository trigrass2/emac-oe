FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://envs/${MACHINE}.txt \
    ${EMAC_SRC_FILES} \
"
UBOOT_MACHINE:soma5d35 ?= "emac-soma5d35_defconfig"
UBOOT_MACHINE:soma5d36 ?= "emac-soma5d36_defconfig"
UBOOT_MACHINE:soma536mp ?= "emac-soma536mp_defconfig"

COMPATIBLE_MACHINE:append = "|(soma5d35|soma5d36|soma536mp)"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}
do_compile:append(){
    if [ "x${SPL_BINARY}" != "x" ]
    then
        cp ${S}/spl/${SPL_BINARY} ${S}/
    fi
}
do_deploy:append() {
        install -D ${B}/u-boot.map ${DEPLOYDIR}/u-boot.map
        install -D ${B}/u-boot.dtb ${DEPLOYDIR}/u-boot.dtb
        install -D ${B}/u-boot-nodtb.bin ${DEPLOYDIR}/u-boot-nodtb.bin
}

EMAC_SRC_FILES = " \
    file://0001-out-of-tree-sources.patch \
    \
    file://emac-sources/configs/emac-soma5d36_defconfig \
    file://emac-sources/configs/emac-soma536mp_defconfig \
    file://emac-sources/arch/arm/dts/som-a5d36-bare.dtsi \
    file://emac-sources/arch/arm/dts/som-a5d36.dts \
    file://emac-sources/arch/arm/dts/som-a536mp.dts \
    file://emac-sources/board/emacinc/soma5d36/Kconfig \
    file://emac-sources/board/emacinc/soma5d36/Makefile \
    file://emac-sources/include/configs/soma5d36.h \
    file://emac-sources/board/emacinc/soma5d36/soma5d36.c \
    \
    file://emac-sources/configs/emac-soma5d35_defconfig \
    file://emac-sources/arch/arm/dts/som-a5d35-bare.dtsi \
    file://emac-sources/arch/arm/dts/som-a5d35.dts \
    file://emac-sources/board/emacinc/soma5d35/Kconfig \
    file://emac-sources/board/emacinc/soma5d35/Makefile \
    file://emac-sources/include/configs/soma5d35.h \
    file://emac-sources/board/emacinc/soma5d35/soma5d35.c \
"
