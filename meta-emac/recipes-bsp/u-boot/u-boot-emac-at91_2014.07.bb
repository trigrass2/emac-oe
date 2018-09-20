SUMMARY = "Universal Boot Loader for embedded devices"
HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

SRCREV = "a06b52a3c6d1b67ac9eba6cfddb1399ab34663dd"
PV = "v2014.07+git${SRCPV}"

SRC_URI = "git://git.emacinc.com/bootloader/u-boot-at91.git;protocol=http"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit uboot-config deploy

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

# Allow setting an additional version string that will be picked up by the
# u-boot build system and appended to the u-boot version.  If the .scmversion
# file already exists it will not be overwritten.
EMAC_UBOOT_VERSION = "SL147-0XS0"
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

do_compile () {

	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS

    i=0
    for config in ${UBOOT_MACHINE}; do
	echo ${UBOOT_LOCALVERSION} | sed "s|X|${i}|g" > ${S}/.scmversion
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
