require recipes-kernel/linux/linux-yocto.inc

LINUX_VER="${@d.getVar('PV',1).split('-')[0]}"
LINUX_VER_SHORT="${@d.getVar('LINUX_VER',1).split('.')[0]}.${@d.getVar('LINUX_VER',1).split('.')[1]}"

PROVIDES += " virtual/kernel kernel-modules "

XENOMAI_SRC_PATH = "${TMPDIR}/work/${MULTIMACH_TARGET_SYS}/xenomai-3/git-${PR}/git"
XENOMAI_DEST_SRC_PATH = "../xenomai"

DEPENDS_append = " xenomai-3 "

S="${WORKDIR}/git"

do_configure_prepend() {
	# proceed xenomai patching
	if [ -e ${WORKDIR}/*ipipe*${LINUX_VER_SHORT}*${ARCH}*.patch ]; then
		${XENOMAI_SRC_PATH}/scripts/prepare-kernel.sh --arch=${ARCH} \
		    --adeos=${WORKDIR}/*ipipe*${LINUX_VER_SHORT}*${ARCH}*.patch --linux=${S}
	fi

	# defconfig is copied in before prepare-kernel, so XENO options are lost
	if [ -e ${WORKDIR}/defconfig ]; then
		cp ${WORKDIR}/defconfig ${B}/.config
		echo "CONFIG_LOCALVERSION="\"${LINUX_VERSION_EXTENSION}\" >> ${B}/.config
	fi
}

KERNEL_MODULE_PACKAGE_SUFFIX = ""
