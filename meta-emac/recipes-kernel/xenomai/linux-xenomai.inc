require recipes-kernel/linux/linux-yocto.inc

LINUX_VER="${@d.getVar('PV',1).split('-')[0]}"
LINUX_VER_SHORT="${@d.getVar('LINUX_VER',1).split('.')[0]}.${@d.getVar('LINUX_VER',1).split('.')[1]}"

PROVIDES += " virtual/kernel kernel-modules "

FILES_kernel-dev += "${KERNEL_LINK_PATH}"

XENOMAI_VER="git"
XENOMAI_SRC_PATH = "${TMPDIR}/work-shared/xenomai-${XENOMAI_VER}/${XENOMAI_VER}"
XENOMAI_DEST_SRC_PATH = "../xenomai"

DEPENDS_append = " xenomai-3"

S="${WORKDIR}/git"

do_configure_prepend() {
	# proceed xenomai patching
	if [ -e ${XENOMAI_SRC_PATH}/kernel/cobalt/arch/${ARCH}/patches/*ipipe*${LINUX_VER_SHORT}*${ARCH}*.patch ]; then
		${XENOMAI_SRC_PATH}/scripts/prepare-kernel.sh --arch=${ARCH} \
		    --adeos=${XENOMAI_SRC_PATH}/kernel/cobalt/arch/${ARCH}/patches/*ipipe*${LINUX_VER_SHORT}*${ARCH}*.patch \
	            --linux=${S}
	else
		${XENOMAI_SRC_PATH}/scripts/prepare-kernel.sh --arch=${ARCH} \
		    --adeos=${S}/kernel/cobalt/arch/${ARCH}/patches/*ipipe*${LINUX_VER_SHORT}*${ARCH}*.patch \
	            --linux=${S}
	fi

	# defconfig is copied in before prepare-kernel, so XENO options are lost
	if [ -e ${WORKDIR}/defconfig ]; then
		cp ${WORKDIR}/defconfig ${B}/.config
	fi
}
