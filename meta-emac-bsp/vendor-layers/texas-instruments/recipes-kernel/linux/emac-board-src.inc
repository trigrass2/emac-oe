EMAC_SRC_FILES:append:som-5728m = " \
    file://0001-machine-dts.patch \
    file://emac-sources/arch/arm/boot/dts/emac-som-5728m.dtsi \
    file://emac-sources/arch/arm/boot/dts/emac-som-5728m-350es.dts \
"

CONFIG_FRAGMENTS:append:som-5728m = " file://som-5728m.cfg"
KERNEL_CONFIG_FRAGMENTS:append:som-5728m = " ${WORKDIR}/som-5728m.cfg"