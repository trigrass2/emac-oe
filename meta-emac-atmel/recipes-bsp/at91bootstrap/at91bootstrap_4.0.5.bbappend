FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

COMPATIBLE_MACHINE:append = '|(soma5d36)'

SRC_URI:append = " \
    file://soma5d36_sd_uboot_defconfig \
"

AT91BOOTSTRAP_MACHINE:soma5d36 ?= "soma5d36"
AT91BOOTSTRAP_TARGET:soma5d36 ?= "soma5d36_sd_uboot_defconfig"
AT91BOOTSTRAP_LOAD:soma5d36 ?= "sdboot-uboot"

do_configure:prepend(){
    mkdir -p ${AT91BOOTSTRAP_CONFIG_PATH}
    cp -f ${WORKDIR}/${AT91BOOTSTRAP_TARGET} ${AT91BOOTSTRAP_CONFIG_PATH}/
}