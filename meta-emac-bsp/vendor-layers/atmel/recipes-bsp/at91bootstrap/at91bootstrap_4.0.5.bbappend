FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

COMPATIBLE_MACHINE:append = '|(soma5d35|soma5d36|ipac9x25|som9x25)'

SRC_URI:append = " \
    file://0002-support-4Gbit-ddr.patch \
    file://soma5d36_sd_uboot_defconfig \
    file://soma5d35_spi_uboot_defconfig \
    file://soma5d36_spi_uboot_defconfig \
    file://ipac9x25_sd_uboot_defconfig \
    file://ipac9x25_spi_uboot_defconfig \
    file://som9x25_sd_uboot_defconfig \
"

AT91BOOTSTRAP_MACHINE:ipac9x25 ?= "ipac9x25"
AT91BOOTSTRAP_TARGET:ipac9x25 ?= "ipac9x25_spi_uboot_defconfig"
AT91BOOTSTRAP_LOAD:ipac9x25 ?= "spiboot-uboot"

AT91BOOTSTRAP_MACHINE:som9x25 ?= "som9x25"
AT91BOOTSTRAP_TARGET:som9x25 ?= "som9x25_sd_uboot_defconfig"
AT91BOOTSTRAP_LOAD:som9x25 ?= "sdboot-uboot"

AT91BOOTSTRAP_MACHINE:soma5d35 ?= "soma5d35"
AT91BOOTSTRAP_TARGET:soma5d35 ?= "soma5d35_spi_uboot_defconfig"
AT91BOOTSTRAP_LOAD:soma5d35 ?= "spiboot-uboot"

AT91BOOTSTRAP_MACHINE:soma5d36 ?= "soma5d36"
AT91BOOTSTRAP_TARGET:soma5d36 ?= "soma5d36_spi_uboot_defconfig"
AT91BOOTSTRAP_LOAD:soma5d36 ?= "spiboot-uboot"

do_configure:prepend(){
    mkdir -p ${AT91BOOTSTRAP_CONFIG_PATH}
    cp -f ${WORKDIR}/${AT91BOOTSTRAP_TARGET} ${AT91BOOTSTRAP_CONFIG_PATH}/
}
do_compile:prepend(){
    export REVISION="-emac-yocto"
}
