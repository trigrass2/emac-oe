SUMMARY = "Initial bootstrap for AT91 ARM MPUs"
DESCRIPTION = " \
		at91bootstrap is the second-level bootloader for Atmel AT91  \
		SoCs. It provides a set of algorithms to manage the hardware \
		initialization and to download the main application (or a    \
		third-level bootloader) from specified boot media to         \
		main memory and start it.                                    \
	      "
AUTHOR = "Atmel Corporation"
HOMEPAGE = "http://www.at91.com/linux4sam/bin/view/Linux4SAM/AT91Bootstrap"
BUGTRACKER = "https://github.com/linux4sam/at91bootstrap/issues"
SECTION = "bootloaders"
LICENSE = "ATMEL"
LIC_FILES_CHKSUM = "file://main.c;endline=27;md5=42f86d2f6fd17d1221c5c651b487a07f"

inherit cml1 deploy

DEPENDS += "bc-native"

BSBRANCH = "emac-bootstrap-3.9.3"
SRCREV = "4a055866e29f25bac8a26d14d20f89bb2451858c"
PV = "v3.9.3+git${SRCPV}"

SRC_URI = "git://git.emacinc.com/bootloader/at91-bootstrap.git;branch=${BSBRANCH};protocol=http"
S = "${WORKDIR}/git"

AT91BOOTSTRAP_MACHINE ??= "${MACHINE}"

AT91BOOTSTRAP_IMAGE ?= "${config}-${PV}.bin"
AT91BOOTSTRAP_BINARY ?= "at91bootstrap.bin"
AT91BOOTSTRAP_SYMLINK ?= "at91bootstrap-${config}.bin"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

EMAC_BOOTSTRAP_VERSION = "SL372-0XS"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
EMAC_BOOTSTRAP_LOCALVERSION ?= "_${EMAC_BOOTSTRAP_VERSION}0${SOM_NUMBER}A${BOOTSTRAP_REV}.bin"
EMAC_BOOTSTRAP_LOCALVERSION_ipac9x25 ?= "_${EMAC_BOOTSTRAP_VERSION}S${SOM_NUMBER}A${BOOTSTRAP_REV}.bin"
BOOTSTRAP_LOCALVERSION = "${EMAC_BOOTSTRAP_LOCALVERSION}+${FIRST_SRCREV}"

do_compile() {

	i=0
	unset CFLAGS CPPFLAGS LDFLAGS
	for config in ${AT91BOOTSTRAP_MACHINE}; do
		if [ $i -gt 0 ]; then
			defconfig=$(echo ${config} | cut -d '_' -f2 )
			cp "${WORKDIR}/defconfig_${defconfig}" "${B}/.config"
			cd ${S}
		else
			cp "${WORKDIR}/defconfig" "${B}/.config"
		fi

		echo ${BOOTSTRAP_LOCALVERSION} | sed "s|X|${i}|g" > ${S}/.scmversion

		oe_runmake AT91BOOTSTRAP=${S}/binaries/$config.bin

	        i=$(expr $i + 1);
	done

	unset i
}

do_install() {
    install -d ${D}/boot
	for config in ${AT91BOOTSTRAP_MACHINE}; do
		install ${S}/binaries/${config}.bin ${D}/boot/${AT91BOOTSTRAP_IMAGE}
	done
}

FILES_${PN} = "/boot"

do_deploy () {
	install -d ${DEPLOYDIR}
	install ${D}/boot/* ${DEPLOYDIR}/
	cd ${DEPLOYDIR}
	for config in ${AT91BOOTSTRAP_MACHINE}; do
		ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_SYMLINK}
	done

}
addtask deploy before do_build after do_install


PACKAGE_ARCH = "${MACHINE_ARCH}"
