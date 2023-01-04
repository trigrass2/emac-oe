DESCRIPTION = "A library to control Adam Modules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRCREV = "7fc98ffe36ea5efa39f6e2d5982956051a618974"

S = "${WORKDIR}/git"

SRC_URI = "git://git@git.emacinc.com/emac-drivers/linux-drivers/adam-module-lib.git;protocol=ssh;branch=master"

do_install() {
    mkdir -p ${D}${libdir}
    mkdir -p ${D}${includedir}
    cp ${S}/adam-module.h ${D}${includedir}/
    cp ${S}/libadammod.a ${D}${libdir}/
}

FILES:${PN} = " \
    ${includedir}/adam-module.h \
    ${libdir}/libadammod.a \
"