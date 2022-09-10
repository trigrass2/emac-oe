FILESEXTRAPATHS:prepend := "${THISDIR}/linux-fslc-imx/${MACHINE}:" 

KBRANCH = "5.15-1.0.x-imx-pmb"
KERNEL_IMAGETYPE = "zImage"
SRCREV = "36e2b746031034d830ad9e30f27de14445bc982f"
LINUX_VERSION = "5.15.48"
LOCALVERSION = "-5.15.5-1.0.0"

SRC_URI:remove = "file://defconfig" 
SRC_URI = "git://git.emacinc.com/linux-kernel/linux-fslc.git;branch=${KBRANCH};protocol=http "

SRC_URI:append:somimx6 = " file://somimx6dq_defconfig "
SRC_URI:append:somimx6ul = " file://somimx6ul_defconfig "

do_kernel_localversion:somimx6:prepend(){
    cp -f ${WORKDIR}/somimx6dq_defconfig ${WORKDIR}/defconfig
    cp -f ${WORKDIR}/somimx6dq_defconfig ${WORKDIR}/git/defconfig
    cp -f ${WORKDIR}/somimx6dq_defconfig ${WORKDIR}/build/.config
}

do_kernel_localversion:somimx6ul:prepend(){
    cp -f ${WORKDIR}/somimx6ul_defconfig ${WORKDIR}/defconfig
    cp -f ${WORKDIR}/somimx6ul_defconfig ${WORKDIR}/git/defconfig
    cp -f ${WORKDIR}/somimx6ul_defconfig ${WORKDIR}/build/.config
}
