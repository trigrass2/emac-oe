FILESEXTRAPATHS:prepend := "${THISDIR}/linux-fslc-imx/${MACHINE}:" 

KERNEL_IMAGETYPE = "zImage"

LINUX_VERSION = "5.15.48"
LOCALVERSION = "-5.15.5-1.0.0"

SRC_URI:remove = "file://defconfig" 

SRC_URI:append:somimx6 = " \
    file://somimx6dq_defconfig \
    file://0001_add_emac_somimx6_board_dts_source.patch \
    file://0002_add_emac_somimx6_board_dts_config.patch \
    file://0003_add_emac_hwmon_driver.patch \
    file://0004_add_emac_power_supply_driver.patch \
"
SRC_URI:append:somimx6ul = " \
    file://somimx6ul_defconfig \
    file://0001_add_emac_somimx6ul_board_dts_source.patch \
    file://0002_add_emac_somimx6ul_board_dts_config.patch \
    file://0003_add_emac_somimx6ul_hwmon_driver.patch \
    file://0004_add_emac_somimx6ul_power_supply_driver.patch \
"

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
