FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

inherit kernel-devicetree

SRC_URI:append = " \
    file://dts-Makefile.patch \
    file://dts/ \
"

COMPATIBLE_MACHINE:append = "|(ipac9x25|som9x25|soma5d35|soma5d36)"

do_configure:prepend(){
    for ext_dts in ${WORKDIR}/dts/${ARCH}/*.dts*; do
        mkdir -p ${S}/arch/${ARCH}/boot/dts
        cp ${ext_dts} ${S}/arch/${ARCH}/boot/dts/
    done
}