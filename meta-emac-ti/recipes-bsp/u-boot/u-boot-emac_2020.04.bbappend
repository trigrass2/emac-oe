FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}/${MACHINE}:"
PROVIDES = "virtual/bootloader"
UBRANCH = "emac-2020.04_som5728"
SRCREV = "7b1e21e8cd0fabbd609e3633c0e99c111cd030da"
SRC_URI = "git://git.emacinc.com/bootloader/u-boot-emac.git;branch=${UBRANCH};protocol=http"
# 
# 
# do_compile(){
#     unset LDFLAGS
#     unset CFLAGS
#     unset CPPFLAGS
#     echo ${UBOOT_LOCALVERSION} | sed "s|X|${i}|g" > ${S}/.scmversion
#     oe_runmake som5728_defconfig 
#     oe_runmake
# }

do_install () {
    install -d ${D}/boot

    for config in ${UBOOT_MACHINE}; do
        name=${config}
        install ${B}/${config}/${UBOOT_BINARY} ${D}/boot/u-boot-${name%_config}-${PV}-${PR}.${UBOOT_SUFFIX}
    done

    if [ "x${SPL_BINARY}" != "x" ]
    then
        for config in ${UBOOT_MACHINE}; do
            for spl in ${SPL_BINARY}; do
                name=`echo ${spl} | cut -d '/' -f 2`
                install ${B}/${config}/spl/u-boot-spl ${D}/boot/${name}
            done
        done
    fi

    if [ "x${UBOOT_ENV}" != "x" ]
    then
        install ${WORKDIR}/${UBOOT_ENV_BINARY} ${D}/boot/${UBOOT_ENV_IMAGE}
        ln -sf ${UBOOT_ENV_IMAGE} ${D}/boot/${UBOOT_ENV_BINARY}
    fi
}
