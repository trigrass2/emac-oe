FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://ipac9x25_mmc_defconfig \
    file://som9x25_mmc_defconfig \
    file://soma5d36_mmc_defconfig \
"

COMPATIBLE_MACHINE:append = '|(ipac9x25|som9x25|soma5d36)'

UBOOT_MACHINE:ipac9x25 ?= "ipac9x25_mmc_defconfig"
UBOOT_MACHINE:som9x25 ?= "som9x25_mmc_defconfig"
UBOOT_MACHINE:soma5d36 ?= "soma5d36_mmc_defconfig"

do_configure:prepend(){
    mkdir -p ${S}/configs
    cp -f ${WORKDIR}/${UBOOT_MACHINE} ${S}/configs/
}