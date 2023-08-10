FILESEXTRAPATHS:prepend := "${THISDIR}/linux-fslc-imx/${MACHINE}:" 

KERNEL_IMAGETYPE = "zImage"

SRC_URI:append:somimx6 = " \
    file://defconfig \
    file://0001_add_emac_somimx6_board_dts_source.patch \
    file://0002_add_emac_somimx6_board_dts_config.patch \
    file://0003_add_emac_hwmon_driver.patch \
    file://0004_add_emac_power_supply_driver.patch \
"
SRC_URI:append:somimx6ul = " \
    file://defconfig \
    file://0001_add_emac_somimx6ul_board_dts_source.patch \
    file://0002_add_emac_somimx6ul_board_dts_config.patch \
    file://0003_add_emac_somimx6ul_hwmon_driver.patch \
    file://0004_add_emac_somimx6ul_power_supply_driver.patch \
"
