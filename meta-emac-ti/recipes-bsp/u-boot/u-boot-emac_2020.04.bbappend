FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}/${MACHINE}:"
PROVIDES = "virtual/bootloader"
UBRANCH = "emac-2020.04_som5728"
SRCREV = "15e93e72b06b35877a31347c6da5f9d91e0ed0ea"
SRC_URI = "git://git.emacinc.com/bootloader/u-boot-emac.git;branch=${UBRANCH};protocol=http"

do_configure (){
    cp ${S}/configs/som5728_defconfig ${B}/.config
    cp ${S}/configs/som5728_defconfig ${B}/defconfig
    
    ## FIXME copy over the u-boot.env file so that it works
}

do_compile () {
    unset LDFLAGS
    unset CFLAGS
    unset CPPFLAGS
    echo ${UBOOT_LOCALVERSION} | sed "s|X|${i}|g" > ${S}/.scmversion
    oe_runmake som5728_defconfig
    oe_runmake all
}

do_install () {
    install -d ${D}/boot
    install ${B}/MLO ${D}/boot/MLO
    install ${B}/u-boot.bin ${D}/boot/u-boot.bin
    install ${B}/u-boot.img ${D}/boot/u-boot.img
    install ${B}/spl/u-boot-spl ${D}/boot/SPL
    if [ "x${UBOOT_ENV}" != "x" ]
    then
        install ${WORKDIR}/${UBOOT_ENV_BINARY} ${D}/boot/${UBOOT_ENV_IMAGE}
        ln -sf ${UBOOT_ENV_IMAGE} ${D}/boot/${UBOOT_ENV_BINARY}
    fi
}
