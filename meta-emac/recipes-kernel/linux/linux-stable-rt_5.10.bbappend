FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-5.10:"

COMPATIBLE_MACHINE = "soma5d36mp"

SRC_URI += " \
	file://defconfig \
    file://dts/som-a5d36.dtsi \
    file://dts/som-a536mp-215gs.dts \
	file://0001-Remove-MFD-Subnode.patch \
    file://0002-dts-Makefile.patch \
"

do_configure:prepend() {
    install ${WORKDIR}/dts/* ${S}/arch/arm/boot/dts/
}