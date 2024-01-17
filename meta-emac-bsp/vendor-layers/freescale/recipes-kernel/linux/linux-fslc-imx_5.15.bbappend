FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:${THISDIR}/${BPN}/drivers:"

SRC_URI:append = " \
    file://0001-add-emac-as-a-user-of-gpio-aggregator.patch \
    file://0001-add-emc2102-fan-sensor.patch \
    file://0002-add-lt8491-charger.patch \
    file://systemd-requirements.cfg \
"

SRC_URI:append:somimx6ul = " \
    file://0002-add-emac-dtb-targets.patch \
    file://0003-add-emac-dtb-sources.patch \
    file://0004-fix-somimx6ul-audio.patch \
    file://0005-fix-wifi-dts.patch \
    file://standard.cfg \
"

SRC_URI:append:somimx6 = " \
    file://0002-add-emac-dtb-targets.patch \
    file://0003-add-emac-dtb-sources.patch \
    file://standard.cfg \
    file://media.cfg \
"
