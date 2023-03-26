FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base:append:som-5728m = " prueth-fw prusw-fw"

COMMON_EMAC_SRC_FILES = ""
CONFIG_FRAGMENTS = " \
    file://${MACHINE}.cfg \
    file://nfsv4-tcp.cfg \
    file://kernel-build-options.cfg \
"

EMAC_SRC_FILES = "${COMMON_EMAC_SRC_FILES}"

EMAC_SRC_FILES:append:som-5728m = " \
    file://machine-dts.patch \
    file://emac-sources/arch/arm/boot/dts/emac-som-5728m.dtsi \
    file://emac-sources/arch/arm/boot/dts/emac-som-5728m-350es.dts \
"

KERNEL_CONFIG_FRAGMENTS = " \
    ${WORKDIR}/${MACHINE}.cfg \
    ${WORKDIR}/nfsv4-tcp.cfg \
    ${WORKDIR}/kernel-build-options.cfg \
"

SRC_URI:append = " \
    ${EMAC_SRC_FILES} \
    ${CONFIG_FRAGMENTS} \
"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}