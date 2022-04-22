DESCRIPTION = "User creation for EMAC OE"
LICENSE = "MIT"

DEPENDS:append = " sudo base-files "
RDEPENDS:${PN} += " base-files "

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://bashrc \
    file://bashrc-root \
    file://profile \
"

do_install:append(){
    install -d ${D}/root
    cp ${WORKDIR}/bashrc-root ${D}/root/.bashrc
    cp ${WORKDIR}/profile ${D}/root/.profile

    install -d ${D}/home/emac
    cp ${WORKDIR}/bashrc  ${D}/home/emac/.bashrc
    cp ${WORKDIR}/profile ${D}/home/emac/.profile
}

FILES:${PN} += " \
    /root \
    /root/.profile \
    /root/.bashrc \
    /home/emac \
    /home/emac/.profile \
    /home/emac/.bashrc \
"
