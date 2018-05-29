SUMMARY = "Universal Boot Loader for embedded devices"
HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

SRCREV = "5c7559e84e96f42d0764345180d295dd39c79c6d"
PV = "v2016.01+git${SRCPV}"

UBRANCH = "emac-2016.01"
SRC_URI = "git://git.emacinc.com/bootloader/u-boot-emac.git;branch=${UBRANCH};protocol=http"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit uboot-config deploy

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

# Allow setting an additional version string that will be picked up by the
# u-boot build system and appended to the u-boot version.  If the .scmversion
# file already exists it will not be overwritten.
EMAC_UBOOT_VERSION = "SL161-00S0"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
EMAC_UBOOT_LOCALVERSION ?= "_${EMAC_UBOOT_VERSION}${SOM_NUMBER}A${UBOOT_REV}.ubin"
UBOOT_LOCALVERSION = "${EMAC_UBOOT_LOCALVERSION}+${FIRST_SRCREV}"

# Some versions of u-boot use .bin and others use .img.  By default use .bin
# but enable individual recipes to change this value.
UBOOT_SUFFIX ?= "bin"
UBOOT_IMAGE ?= "u-boot-${MACHINE}-${PV}-${PR}.${UBOOT_SUFFIX}"
UBOOT_BINARY ?= "u-boot.${UBOOT_SUFFIX}"
UBOOT_SYMLINK ?= "u-boot-${MACHINE}.${UBOOT_SUFFIX}"
UBOOT_MAKE_TARGET ?= "all"

# Some versions of u-boot build an SPL (Second Program Loader) image that
# should be packaged along with the u-boot binary as well as placed in the
# deploy directory.  For those versions they can set the following variables
# to allow packaging the SPL.
SPL_BINARY ?= ""
SPL_IMAGE ?= "${SPL_BINARY}-${MACHINE}-${PV}-${PR}"
SPL_SYMLINK ?= "${SPL_BINARY}-${MACHINE}"

SPL_BINARY_TWO ?= ""
SPL_IMAGE_TWO ?= "${SPL_BINARY_TWO}-${MACHINE}-${PV}-${PR}"
SPL_SYMLINK_TWO ?= "${SPL_BINARY_TWO}-${MACHINE}"


# Additional environment variables or a script can be installed alongside
# u-boot to be used automatically on boot.  This file, typically 'uEnv.txt'
# or 'boot.scr', should be packaged along with u-boot as well as placed in the
# deploy directory.  Machine configurations needing one of these files should
# include it in the SRC_URI and set the UBOOT_ENV parameter.
UBOOT_ENV_SUFFIX ?= "txt"
UBOOT_ENV ?= ""
UBOOT_ENV_BINARY ?= "${UBOOT_ENV}.${UBOOT_ENV_SUFFIX}"
UBOOT_ENV_IMAGE ?= "${UBOOT_ENV}-${MACHINE}-${PV}-${PR}.${UBOOT_ENV_SUFFIX}"
UBOOT_ENV_SYMLINK ?= "${UBOOT_ENV}-${MACHINE}.${UBOOT_ENV_SUFFIX}"

do_compile () {
    unset LDFLAGS
    unset CFLAGS
    unset CPPFLAGS

    i=0
    for config in ${UBOOT_MACHINE}; do
        LOCALVERSION=${UBOOT_LOCALVERSION}
        echo ${LOCALVERSION:0:8}${i}${LOCALVERSION:8} > ${S}/.scmversion
        oe_runmake -C ${S} O=${B}/${config} ${config}
        oe_runmake -C ${S} O=${B}/${config} ${UBOOT_MAKE_TARGET}
        i=$(expr $i + 1);
    done
    unset  i
}

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
                install ${B}/${config}/${spl} ${D}/boot/${name}
            done
        done
    fi

    if [ "x${UBOOT_ENV}" != "x" ]
    then
        install ${WORKDIR}/${UBOOT_ENV_BINARY} ${D}/boot/${UBOOT_ENV_IMAGE}
        ln -sf ${UBOOT_ENV_IMAGE} ${D}/boot/${UBOOT_ENV_BINARY}
    fi
}

FILES_${PN} = "/boot"

do_deploy () {
    install -d ${DEPLOYDIR}
    install ${D}/boot/* ${DEPLOYDIR}/
    cd ${DEPLOYDIR}
    for config in ${UBOOT_MACHINE}; do
        name=${config}
        ln -sf u-boot-${name%_config}-${PV}-${PR}.${UBOOT_SUFFIX} u-boot-${name%_config}.${UBOOT_SUFFIX}
    done
}

addtask deploy before do_build after do_install
