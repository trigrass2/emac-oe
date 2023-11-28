FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://0001_add_emac_somimx6_board_source.patch \
    file://0002_add_emac_somimx6_board_config.patch \
"
