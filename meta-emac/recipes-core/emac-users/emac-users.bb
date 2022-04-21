DESCRIPTION = "User creation for EMAC OE"
LICENSE = "MIT"

DEPENDS += " sudo base-files "
RDEPENDS_${PN} += " base-files "

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://bashrc \
    file://bashrc-root \
    file://profile \
"

do_install_append(){
    install -d ${D}/root
    cp ${WORKDIR}/bashrc-root ${D}/root/.bashrc
    cp ${WORKDIR}/profile ${D}/root/.profile

    install -d ${D}/home/emac
    cp ${WORKDIR}/bashrc  ${D}/home/emac/.bashrc
    cp ${WORKDIR}/profile ${D}/home/emac/.profile
}

FILES_${PN} += " \
    /root \
    /root/.profile \
    /root/.bashrc \
    /home/emac \
    /home/emac/.profile \
    /home/emac/.bashrc \
"
