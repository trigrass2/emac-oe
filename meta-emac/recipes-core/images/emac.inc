LICENSE = "GPLv2"

IMAGE_TYPE ?= "Headless"
BUILD_TYPE ?= "headless"
EXTRA_PKGS ?= ""
FS_NUMBER ?= "00"

inherit image
inherit extrausers

EXTRA_USERS_PARAMS:append = " \
    usermod -p '\$1\$toNMNUq8\$73DgW8yu5SZeY5PRzleI.0' root; \
    usermod -d /root root; \
    useradd -p '\$1\$UMtWLrpz\$Hpp1KSgg5zCwcxMZW1FsP1' emac; \
    usermod -aG sudo emac; \
    usermod -aG dialout emac; \
    usermod -aG video emac; \
    usermod -d /home/emac emac; \
"

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_BUILDINFO_VARS = "DATE DISTRO_NAME DISTRO_VERSION IMAGE_BASENAME MACHINE TUNE_PKGARCH EXTRA_PKGS"

IMAGE_FSTYPES ?= " ext4 tar.gz"
IMAGE_FSTYPES:remove = "tar.xz wic.xz"

fix_rootfs() {
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
    
    if [ "${EMAC_INITMANAGER}" -eq "sysvinit" ]; 
    then
        ln -s ../init.d/run-postinsts ${IMAGE_ROOTFS}${sysconfdir}/rcS.d/S99postinsts
    fi
}

ROOTFS_POSTPROCESS_COMMAND:append = " fix_rootfs; "
