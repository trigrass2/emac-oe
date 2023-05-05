FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"


COMMON_EMAC_SRC_FILES = " \
    file://emac-sources/board/emacinc/common/Kconfig \
    file://emac-sources/board/emacinc/common/board_detect.c \
    file://emac-sources/board/emacinc/common/Makefile \
    file://emac-sources/board/emacinc/common/board_detect.h \
"
EMAC_SRC_FILES = "${COMMON_EMAC_SRC_FILES}"

EMAC_SRC_FILES:append:som-5728m = " \
    file://emac-sources/configs/emac-som-5728m_defconfig \
    file://emac-sources/include/configs/emac-som-5728m.h \
    file://emac-sources/arch/arm/dts/emac-som-5728m-350es.dts \
    file://emac-sources/arch/arm/dts/emac-som-5728m.dtsi \
    file://emac-sources/board/emacinc/som-5728m/Kconfig \
    file://emac-sources/board/emacinc/som-5728m/MAINTAINERS \
    file://emac-sources/board/emacinc/som-5728m/board.c \
    file://emac-sources/board/emacinc/som-5728m/Makefile \
    file://emac-sources/board/emacinc/som-5728m/mux_data.h \
"

SRC_URI:append = " \
    file://board-add.patch \
    file://u-boot-default.txt \
    ${EMAC_SRC_FILES} \
"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/

    if [ -f "${WORKDIR}/u-boot-default.txt" ]; then
        cp ${WORKDIR}/u-boot-default.txt ${S}/u-boot-default.txt
    fi
}