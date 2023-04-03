FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base:append:som-5728m = " prueth-fw prusw-fw"

EMAC_SRC_FILES = ""
KERNEL_CONFIG_FRAGMENTS = ""

CONFIG_FRAGMENTS = " \
    file://nfsv4-tcp.cfg \
    file://kernel-build-options.cfg \
"

KERNEL_CONFIG_FRAGMENTS:append = " \
    ${WORKDIR}/nfsv4-tcp.cfg \
    ${WORKDIR}/kernel-build-options.cfg \
"

include emac-board-src.inc

SRC_URI:append = " \
    ${EMAC_SRC_FILES} \
    ${CONFIG_FRAGMENTS} \
"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
}