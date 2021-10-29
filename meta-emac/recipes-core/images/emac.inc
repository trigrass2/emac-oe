LICENSE = "GPLv2"

IMAGE_TYPE ?= "Headless"
BUILD_TYPE ?= "headless"
EXTRA_PKGS ?= ""
FS_NUMBER ?= "00"

inherit image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_BUILDINFO_VARS = "DATE DISTRO_NAME DISTRO_VERSION IMAGE_BASENAME MACHINE TUNE_PKGARCH PART_NUMBER EXTRA_PKGS"

fix_rootfs() {

    sed -i -e "s|^root:.*$|root:4fkNNeH5j4zNk::0:99999:7:::|" ${IMAGE_ROOTFS}${sysconfdir}/shadow

    echo "${DISTRO_NAME} ${DISTRO_VERSION} - ${DISTRO_RELEASE}" > ${IMAGE_ROOTFS}${sysconfdir}/issue
    echo "${DISTRO_NAME} - ${DISTRO_VERSION} - ${DISTRO_RELEASE}" > ${IMAGE_ROOTFS}${sysconfdir}/issue.net

    echo "Copyright (C) "`date +"%Y"`", EMAC Inc.  All rights reserved." >> ${IMAGE_ROOTFS}${sysconfdir}/issue
    echo "Copyright (C) "`date +"%Y"`", EMAC Inc.  All rights reserved." >> ${IMAGE_ROOTFS}${sysconfdir}/issue.net

    echo >> ${IMAGE_ROOTFS}${sysconfdir}/issue
    echo >> ${IMAGE_ROOTFS}${sysconfdir}/issue.net

    echo "${IMAGE_TYPE}" >> ${IMAGE_ROOTFS}${sysconfdir}/issue
    echo "${IMAGE_TYPE}" >> ${IMAGE_ROOTFS}${sysconfdir}/issue.net

    echo "${MACHINE}" >> ${IMAGE_ROOTFS}${sysconfdir}/issue
    echo "${MACHINE}" >> ${IMAGE_ROOTFS}${sysconfdir}/issue.net

    echo >> ${IMAGE_ROOTFS}${sysconfdir}/issue
    echo >> ${IMAGE_ROOTFS}${sysconfdir}/issue.net

    # Run populate-volatile.sh at rootfs time to set up basic files
    # and directories to support read-only rootfs.
    if [ -x ${IMAGE_ROOTFS}/etc/init.d/populate-volatile.sh ]; then
        ${IMAGE_ROOTFS}/etc/init.d/populate-volatile.sh
    fi
    if [ -e ${IMAGE_ROOTFS}${datadir}/applications/htop.desktop ];then
        rm -f ${IMAGE_ROOTFS}${datadir}/applications/htop.desktop
    fi
    if [ "${EMAC_INIT_MANGER}" -eq "sysvinit" ]; then
        ln -s ../init.d/run-postinsts ${IMAGE_ROOTFS}${sysconfdir}/rcS.d/S99postinsts
    fi
}

ROOTFS_POSTPROCESS_COMMAND += " fix_rootfs; "
