FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://envs/${MACHINE}.txt \
    ${EMAC_SRC_FILES} \
"

DEPENDS += " \
    xxd-native \
"

UBOOT_MACHINE:ipac9x25 ?= "emac-ipac9x25_defconfig"
UBOOT_MACHINE:som9x25 ?= "emac-som9x25m_defconfig"
UBOOT_MACHINE:som3354 ?= "emac-som3354_defconfig"

# SPL (Second Program Loader) to be loaded over UART
SPL_UART_BINARY = ""
SPL_UART_BINARY:ti33x = "u-boot-spl.bin"
SPL_UART_IMAGE ?= "${SPL_UART_BINARY}-${MACHINE}-${PV}-${PR}"
SPL_UART_SYMLINK ?= "${SPL_UART_BINARY}-${MACHINE}"

COMPATIBLE_MACHINE:append = "|(ipac9x25|som9x25|som3354)"

do_configure:prepend(){
    cp -r ${WORKDIR}/emac-sources/* ${S}/
    cp ${WORKDIR}/envs/${MACHINE}.txt ${S}/u-boot-default-env.txt
}

do_install:append () {
	if [ -n "${UBOOT_CONFIG}" ]
	then
		for config in ${UBOOT_MACHINE}; do
			i=$(expr $i + 1);
			for type in ${UBOOT_CONFIG}; do
				j=$(expr $j + 1);
				if [ $j -eq $i ]
				then
					if [ "x${SPL_UART_BINARY}" != "x" ]; then
						install ${B}/${config}/spl/${SPL_UART_BINARY} ${D}/boot/${SPL_UART_IMAGE}-${type}
						ln -sf ${SPL_UART_IMAGE}-${type} ${D}/boot/${SPL_UART_BINARY}-${type}
						ln -sf ${SPL_UART_IMAGE}-${type} ${D}/boot/${SPL_UART_BINARY}
					fi
				fi
			done
			unset  j
		done
		unset  i
	else
		if [ "x${SPL_UART_BINARY}" != "x" ]; then
			install ${B}/spl/${SPL_UART_BINARY} ${D}/boot/${SPL_UART_IMAGE}
			ln -sf ${SPL_UART_IMAGE} ${D}/boot/${SPL_UART_BINARY}
		fi
	fi
}

do_deploy:append () {
	if [ -n "${UBOOT_CONFIG}" ]
	then
		for config in ${UBOOT_MACHINE}; do
			i=$(expr $i + 1);
			for type in ${UBOOT_CONFIG}; do
				j=$(expr $j + 1);
				if [ $j -eq $i ]
				then
					cd ${DEPLOYDIR}
					if [ "x${SPL_UART_BINARY}" != "x" ]; then
						install ${B}/${config}/spl/${SPL_UART_BINARY} ${SPL_UART_IMAGE}-${type}
						rm -f ${SPL_UART_BINARY} ${SPL_UART_SYMLINK}
						ln -sf ${SPL_UART_IMAGE}-${type} ${SPL_UART_BINARY}-${type}
						ln -sf ${SPL_UART_IMAGE}-${type} ${SPL_UART_BINARY}
						ln -sf ${SPL_UART_IMAGE}-${type} ${SPL_UART_SYMLINK}-${type}
						ln -sf ${SPL_UART_IMAGE}-${type} ${SPL_UART_SYMLINK}
					fi
				fi
			done
			unset  j
		done
		unset  i
	else
		cd ${DEPLOYDIR}
		if [ "x${SPL_UART_BINARY}" != "x" ]; then
			install ${B}/spl/${SPL_UART_BINARY} ${SPL_UART_IMAGE}
			rm -f ${SPL_UART_BINARY} ${SPL_UART_SYMLINK}
			ln -sf ${SPL_UART_IMAGE} ${SPL_UART_BINARY}
			ln -sf ${SPL_UART_IMAGE} ${SPL_UART_SYMLINK}
		fi
	fi
}

EMAC_SRC_FILES = " \
    file://0001-out-of-tree-sources.patch \
    file://0002-som-3354-config-targets.patch \
    file://0001-atmel-usba-fix-transfer-of-queued-requests.patch \
    file://0001-Support-for-enabling-the-TPS65910-boost-regulator.patch \
    \
    file://emac-sources/configs/emac-ipac9x25_defconfig \
    file://emac-sources/arch/arm/dts/ipac-9x25.dts \
    file://emac-sources/board/emacinc/ipac9x25/Kconfig \
    file://emac-sources/board/emacinc/ipac9x25/Makefile \
    file://emac-sources/include/configs/ipac9x25.h \
    file://emac-sources/board/emacinc/ipac9x25/ipac9x25.c \
    \
    file://emac-sources/configs/emac-som9x25m_defconfig \
    file://emac-sources/arch/arm/dts/som-9x25m.dts \
    file://emac-sources/board/emacinc/som9x25m/Kconfig \
    file://emac-sources/board/emacinc/som9x25m/Makefile \
    file://emac-sources/include/configs/som9x25m.h \
    file://emac-sources/board/emacinc/som9x25m/som9x25m.c \
    \
    file://emac-sources/configs/emac-som3354_defconfig \
    file://emac-sources/arch/arm/dts/som-3354.dts \
    file://emac-sources/include/configs/som3354.h \
    file://emac-sources/board/emacinc/som3354/Kconfig \
    file://emac-sources/board/emacinc/som3354/Makefile \
    file://emac-sources/board/emacinc/som3354/MAINTAINERS \
    file://emac-sources/board/emacinc/som3354/u-boot.lds \
    file://emac-sources/board/emacinc/som3354/mux.c \
    file://emac-sources/board/emacinc/som3354/board.c \
    file://emac-sources/board/emacinc/som3354/board.h \
"
