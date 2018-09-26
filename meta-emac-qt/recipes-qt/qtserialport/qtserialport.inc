SUMMARY = "Qt Serial Port Library"
SECTION = "qt/libs"
HOMEPAGE = "http://qt-project.org/wiki/QtSerialPort"

LICENSE = "(LGPL-2.1 | GPL-3.0) & GFDL-1.3"
LIC_FILES_CHKSUM = " \
    file://LICENSE.FDL;md5=3801d7932fdc07fd9efe89f9854a6caa \
    file://LICENSE.GPL;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.LGPL;md5=4fbd65380cdd255951079008b364516c \
    "

inherit pkgconfig

SRC_URI = " \
    git://code.qt.io/qt/qtserialport.git;branch=qt4-dev \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/${BPN}-${PV}"

QMAKE_PROFILES = "${S}/qtserialport.pro"
OE_QMAKE_QMAKE = "${WORKDIR}/qmake2"

do_prepare_qmake_symlink() {
    ln -sf "${STAGING_BINDIR_NATIVE}/qmake2" ${WORKDIR}
}

addtask prepare_qmake_symlink after do_generate_qt_config_file before do_configure

do_configure_prepend() {
    sed -i -e "s|\(Prefix\ =\).*|\1\ ${prefix}|" ${WORKDIR}/qt.conf
    sed -i -e "s|\(Headers\ =\).*|\1\ ${includedir}/qtopia|" ${WORKDIR}/qt.conf
    sed -i -r -e "/^(Binaries|Plugins|Mkspecs)/ d" ${WORKDIR}/qt.conf 
}

do_install() {
    oe_runmake install INSTALL_ROOT=${D}
}

FILES_${PN}-dev += " \
    ${includedir}/QtSerialPort/* \
    ${prefix}/mkspecs/* \
    ${libdir}/*.prl \
"

FILES_${PN}-dbg += " \
    ${libdir}/.debug/* \
"
