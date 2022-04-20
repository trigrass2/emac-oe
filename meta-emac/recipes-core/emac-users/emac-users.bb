DESCRIPTION = "User creation for EMAC OE"
LICENSE = "MIT"

inherit extrausers
IMAGE_CLASSES += "extrausers"

RDEPENDS_${PN} += " base-files "


FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://bashrc \
    file://bashrc-root \
    file://profile \
"

ROOTPASSWD = "ga4u8j0W5umY."
PASSWD = "fb7SZfwDJvKFo"

USERADDEXTENSION = "useradd-staticids"
# USERADD_UID_TABLES = "files/passwd"
# USERADD_GID_TABLES = "files/group"

EXTRA_USERS_PARAMS = " \
    usermod -p '${ROOTPASSWD}' root; \
    usermod -d /root root; \
        useradd emac; \
        usermod -p '${PASSWD}' emac; \
        usermod -aG sudo emac; \
        usermod -aG dialout emac; \
        usermod -d /home/emac emac; \
"

            
            
do_install_append(){
    install -d ${D}/home/root
    cp ${WORKDIR}/bashrc-root ${D}/home/root/.bashrc
    cp ${WORKDIR}/profile ${D}/home/root/.profile

    install -d ${D}/home/emac
    cp ${WORKDIR}/bashrc  ${D}/home/emac/.bashrc
    cp ${WORKDIR}/profile ${D}/home/emac/.profile
}


FILES_${PN} += " \
    /home/root \
    /home/root/.profile \
    /home/root/.bashrc \
    /home/emac \
    /home/emac/.profile \
    /home/emac/.bashrc \
"
