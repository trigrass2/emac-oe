#
# Copyright (C) 2016  EMAC Inc, All rights reserved
#

DESCRIPTION = "EMAC Core Package Groups"
LICENSE = "GPLv2"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = " \
    ${PN} \
    ${PN}-util \
    ${PN}-networking \
    ${PN}-packagemanagement \
    ${PN}-wifi  \
    ${PN}-x86 \
    ${PN}-arm \
    ${PN}-touch \
    ${PN}-sound \
    ${PN}-mtd \
    ${PN}-can  \
    ${PN}-pci \
    ${PN}-rt \ 
"

PACKAGES = " \
    ${PN} \
    ${PN}-util \
    ${PN}-networking \
    ${PN}-packagemanagement \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", " packagegroup-emac-core-x86 ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "arm", " packagegroup-emac-core-arm ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", " packagegroup-emac-core-touch ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", " packagegroup-emac-core-wifi ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "sound", " packagegroup-emac-core-sound ", '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", " packagegroup-emac-core-mtd ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", " packagegroup-emac-core-can ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", " packagegroup-emac-core-pci ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "rt", " packagegroup-emac-core-rt ", "", d)} \
"

SUMMARY:${PN} = "EMAC OE Core Utilities"
RRECOMMENDS:${PN} = " \
    e2fsprogs \
    e2fsprogs-tune2fs \
    kernel-modules \
    kernel-base \
    sysfsutils \
    udev-extraconf \
    util-linux-mount \
    tzcode \
    ${PN}-util \
    ${PN}-networking \
    ${PN}-packagemanagement \
"

SUMMARY:${PN}-util = "EMAC OE Core Utilities"
RRECOMMENDS:${PN}-util = " \
    bash \
    libgpiod \
    libgpiod-tools \
    libgpiodcxx \
    sudo \
    usbutils \
    rng-tools \
"

SUMMARY:${PN}-networking = "EMAC OE Networking Utilities"
RRECOMMENDS:${PN}-networking = " \
    ifplugd \
    openssh \
    rsync \
    ntpdate sntp ntpdc ntpq ntp-tickadj ntp-utils ntp ppp \
    ${@bb.utils.contains("EMAC_NETWORKMANGER", "connman", " connman connman-conf  connman-tools connman-client ", " ", d)} \
    ${@bb.utils.contains("EMAC_NETWORKMANGER", "networkmanager", " networkmanager networkmanager-nmcli networkmanager-wifi networkmanager-nmtui networkmanager-bash-completion", " ", d)} \
"


SUMMARY:${PN}-packagemanagement = "EMAC OE Package Management"
RRECOMMENDS:${PN}-packagemanagement = " \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "rpm", " dnf rpm ", "", d)} \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "ipk", " libarchive opkg opkg-utils ", "", d)} \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "deb", " apt dpkg ", "", d)} \
"

SUMMARY:${PN}-touch = "EMAC OE Touch Utilities"
RRECOMMENDS:${PN}-touch = " \
    tslib-calibrate \
    tslib-conf \
    tslib-tests \
    tslib \
"

SUMMARY:${PN}-wifi = "EMAC OE Wifi Utilities"
RRECOMMENDS:${PN}-wifi = " \
    iw \
    wpa-supplicant \
    wireless-tools \
    bluez5 \
    ${@bb.utils.contains("EMAC_NETWORKMANGER", "networkmanager", " modemmanager ", " ", d)} \
"

#    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", " audio-demos ", "", d)} 
SUMMARY:${PN}-sound = "EMAC OE SOUND Utilities"
RRECOMMENDS:${PN}-sound = " \
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "alsa", " \
        alsa-utils-alsamixer alsa-utils-midi \ 
        alsa-utils-aplay alsa-utils-amixer \
        alsa-utils-speakertest alsa-utils-alsaloop \
        alsa-utils-alsactl alsa-state " , "", d)} \
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "pulseaudio", " pulseaudio-server pulseaudio-misc ", "", d)} \
    mpg123 \
    libltdl \
"

SUMMARY:${PN}-mtd = "EMAC OE MTD Utilities"
RRECOMMENDS:${PN}-mtd = " \
    mtd-utils \
    mtd-utils-jffs2 \
"

SUMMARY:${PN}-x86 = "EMAC OE x86 Packages."
RRECOMMENDS:${PN}-x86 = "grub"

SUMMARY:${PN}-arm = "EMAC OE Arm 32 Packages."
RRECOMMENDS:${PN}-arm = " \
    serial-control \
    apm \
    libubootenv-bin \
"

SUMMARY:${PN}-can = "EMAC OE CAN Packages."
RRECOMMENDS:${PN}-can = " can-utils "

SUMMARY:${PN}-pci = "EMAC OE PCI Packages."
RRECOMMENDS:${PN}-pci = " pciutils "

SUMMARY:${PN}-rt = "EMAC OE RT Packages."
RRECOMMENDS:${PN}-rt = " \
    rt-tests \
    hwlatdetect \
"
