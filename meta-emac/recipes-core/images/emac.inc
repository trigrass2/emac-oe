IMAGE_LINGUAS = " "

LICENSE = "GPLv2"

IMAGE_TYPE ?= "Headless"
BUILD_TYPE ?= "headless"
EXTRA_PKGS ?= ""
FS_NUMBER ?= "0"

inherit core-image syslinux distro_features_check

IMAGE_ROOTFS_SIZE = "8192"

def get_layer_version(layer_subdir=None, repo_type="git"):
    # layer_subdir is a proper subdirectory of some OE layer which is some kind
    # of repository. Conceivably, this could be any kind of repository

    layer_version = "No git repository"

    try:
        from git import (Repo, InvalidGitRepositoryError)
        repo = Repo(layer_subdir,search_parent_directories=True)
        layer_version = repo.commit().hexsha
        for tag in repo.tags:
	    if tag.commit.hexsha == layer_version:
	        layer_version = tag.name
                break
        if repo.is_dirty():
            layer_version = layer_version + "+"
    finally:
        return layer_version

LAYER_VERSION := "${@get_layer_version('${THISDIR}')}" 

fix_rootfs() {
	VERSION_FILE=${IMAGE_ROOTFS}${sysconfdir}/version
	echo "distro_name=\"${DISTRO_NAME}\"" > ${VERSION_FILE}
	echo "version=\"${DISTRO_VERSION}\"" >> ${VERSION_FILE}
	echo "build_type=\"${BUILD_TYPE}\"" >> ${VERSION_FILE}
	echo  >> ${VERSION_FILE}
	echo "arch=\"${TUNE_PKGARCH}\"" >> ${VERSION_FILE}
	echo  >> ${VERSION_FILE}
	echo "release_date=\"${RELEASE_DATE}\"" >> ${VERSION_FILE}
	echo "build_date=\""`date +"%b %d, %Y"`"\"" >> ${VERSION_FILE}
	echo "version_major=${MAJOR_DISTRO_VERSION}" >> ${VERSION_FILE}
	echo "version_minor=${MINOR_DISTRO_VERSION}" >> ${VERSION_FILE}
	echo "version_patch=${PATCH_DISTRO_VERSION}" >> ${VERSION_FILE}
	echo "version_release=\"${DISTRO_RELEASE}\"" >> ${VERSION_FILE}
	echo "version_name=\"${DISTRO_NAME} ${DISTRO_VERSION}\"" >> ${VERSION_FILE}
	echo  >> ${VERSION_FILE}
	echo "repository_version=\"${LAYER_VERSION}\"" >> ${VERSION_FILE}
	echo  >> ${VERSION_FILE}
	echo "part_number=\"${PART_NUMBER}\"" >> ${VERSION_FILE}
	echo "extra_pkgs=\"${EXTRA_PKGS}\"" >> ${VERSION_FILE}
	[ -n "${CARRIER}" ] && echo "carrier=\"${CARRIER}\"" >> ${VERSION_FILE}
	echo  >> ${VERSION_FILE}

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
	ln -s ../init.d/run-postinsts ${IMAGE_ROOTFS}${sysconfdir}/rcS.d/S99postinsts
}

ROOTFS_POSTPROCESS_COMMAND += " fix_rootfs; "
