FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://armv5te_qmake.conf \
             file://armv7a_qmake.conf \
             file://i586_qmake.conf \
             file://core2_qmake.conf \
             file://qplatformdefs.h \
             file://config.xml \
"

do_install_append() {
    install -d ${D}${datadir}/${QT_DIR_NAME}/mkspecs/armv5te-emac-linux-gnueabi-g++
    install -m 644 ${WORKDIR}/armv5te_qmake.conf ${D}${datadir}/${QT_DIR_NAME}/mkspecs/armv5te-emac-linux-gnueabi-g++/qmake.conf
    install -m 644 ${WORKDIR}/qplatformdefs.h ${D}${datadir}/${QT_DIR_NAME}/mkspecs/armv5te-emac-linux-gnueabi-g++/

    install -d ${D}${datadir}/${QT_DIR_NAME}/mkspecs/armv7a-emac-linux-gnueabi-g++
    install -m 644 ${WORKDIR}/armv7a_qmake.conf ${D}${datadir}/${QT_DIR_NAME}/mkspecs/armv7a-emac-linux-gnueabi-g++/qmake.conf
    install -m 644 ${WORKDIR}/qplatformdefs.h ${D}${datadir}/${QT_DIR_NAME}/mkspecs/armv7a-emac-linux-gnueabi-g++/

    install -d ${D}${datadir}/${QT_DIR_NAME}/mkspecs/i586-emac-linux-g++
    install -m 644 ${WORKDIR}/i586_qmake.conf ${D}${datadir}/${QT_DIR_NAME}/mkspecs/i586-emac-linux-g++/qmake.conf
    install -m 644 ${WORKDIR}/qplatformdefs.h ${D}${datadir}/${QT_DIR_NAME}/mkspecs/i586-emac-linux-g++/

    install -d ${D}${datadir}/${QT_DIR_NAME}/mkspecs/core2-emac-linux-g++
    install -m 644 ${WORKDIR}/core2_qmake.conf ${D}${datadir}/${QT_DIR_NAME}/mkspecs/core2-emac-linux-g++/qmake.conf
    install -m 644 ${WORKDIR}/qplatformdefs.h ${D}${datadir}/${QT_DIR_NAME}/mkspecs/core2-emac-linux-g++/

    install -d ${D}${bindir}/qtopia/demos/embedded/fluidlauncher/
    install -m 644 ${WORKDIR}/config.xml ${D}${bindir}/qtopia/demos/embedded/fluidlauncher/
}
