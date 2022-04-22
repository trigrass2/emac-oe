SUMMARY = "The EVL project is now Xenomai 4."
DESCRIPTION = "A library, which enables invoking the real-time core services from applications."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2500c28da9dacbee31a3f4d4f69b74d0"

DEPENDS:append = " linux-evl "
PV .= "+git${SRCPV}"

S = "${WORKDIR}/git"
SRCREV = "50d5fb12eb75f168be47ac8367737e60e2ef5f17"
SRC_TAG = "master"

SRC_URI = " \
    git://git.emacinc.com/Linux-Kernel/libevl.git;branch=${SRC_TAG};protocol=http \
"

EXTRA_OEMAKE = " \
    O='${S}' \
    ARCH='arm' \
    CROSS_COMPILE='${TARGET_SYS}-' \
    UAPI='${STAGING_KERNEL_DIR}' \
    DESTDIR='${D}${libdir}' \
"

EXTRA_OEMAKE:append = " MAKE_SKIP_INSTALL_RPATH=TRUE "

do_configure(){
    echo "nothing to do"
}

do_compile() {
    cd ${S}
    oe_runmake all
}


FILES:${PN}-dev += " \
    /tests/* \
    /tidbits/* \
"

do_install() {
    oe_runmake install_all 'DESTDIR=${D}'  
}

INSANE_SKIP:append = " useless-rpaths "
