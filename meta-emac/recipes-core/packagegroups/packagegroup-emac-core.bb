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
    ${PN}-users \
    ${PN}-wifi  \
    ${PN}-screen \
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
    ${PN}-users \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", " packagegroup-emac-core-x86 ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "arm", " packagegroup-emac-core-arm ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", " packagegroup-emac-core-touch ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", " packagegroup-emac-core-wifi ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "sound", " packagegroup-emac-core-sound ", '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", " packagegroup-emac-core-mtd ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "screen", " packagegroup-emac-core-screen ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", " packagegroup-emac-core-can ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", " packagegroup-emac-core-pci ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "rt", " packagegroup-emac-core-rt ", "", d)} \
"

#    eudev-hwdb
#    kernel-devicetree 
SUMMARY_${PN} = "EMAC OE Core Utilities"
RRECOMMENDS_${PN} = " \
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
    ${PN}-users \
"

SUMMARY_${PN}-util = "EMAC OE Core Utilities"
RRECOMMENDS_${PN}-util = " \
    bash \
    libgpiod \
    libgpiod-tools \
    sudo \
    usbutils \
"

SUMMARY_${PN}-networking = "EMAC OE Networking Utilities"
RRECOMMENDS_${PN}-networking = " \
    ifplugd \
    openssh \
    rsync \
    ntp ntpdc ntpq ntp-tickadj ntp-utils ntpdate \
    ${@bb.utils.contains("EMAC_NETWORKMANGER", "connman", " connman connman-conf  connman-tools connman-client ", " ", d)} \
    ${@bb.utils.contains("EMAC_NETWORKMANGER", "networkmanager", " networkmanager networkmanager-nmtui networkmanager-bash-completion ", " ", d)} \
"


SUMMARY_${PN}-packagemanagement = "EMAC OE Package Management"
RRECOMMENDS_${PN}-packagemanagement = " \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "rpm", " dnf rpm ", "", d)} \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "ipk", " libarchive opkg opkg-utils ", "", d)} \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "deb", " apt dpkg ", "", d)} \
"

SUMMARY_${PN}-users = "EMAC OE Users"
RRECOMMENDS_${PN}-users = " \
    emac-users \
"

SUMMARY_${PN}-touch = "EMAC OE Touch Utilities"
RRECOMMENDS_${PN}-touch = " \
    tslib-calibrate \
    tslib-conf \
    tslib-tests \
    tslib \
"

SUMMARY_${PN}-wifi = "EMAC OE Wifi Utilities"
RRECOMMENDS_${PN}-wifi = " \
    iw \
    wpa-supplicant \
    wireless-tools \
    bluez5 \
"

#    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", " audio-demos ", "", d)} 
SUMMARY_${PN}-sound = "EMAC OE SOUND Utilities"
RRECOMMENDS_${PN}-sound = " \
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "alsa", " \
        alsa-utils-alsamixer alsa-utils-midi \ 
        alsa-utils-aplay alsa-utils-amixer \
        alsa-utils-speakertest alsa-utils-alsaloop \
        alsa-utils-alsactl alsa-state " , "", d)} \
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "pulseaudio", " pulseaudio-server pulseaudio-misc ", "", d)} \
    mpg123 \
    libltdl \
"

SUMMARY_${PN}-mtd = "EMAC OE MTD Utilities"
RRECOMMENDS_${PN}-mtd = " \
    mtd-utils \
    mtd-utils-jffs2 \
"

SUMMARY_${PN}-x86 = "EMAC OE x86 Packages."
RRECOMMENDS_${PN}-x86 = "grub"

SUMMARY_${PN}-arm = "EMAC OE Arm 32 Packages."
RRECOMMENDS_${PN}-arm = " \
    serial-control \
    apm \
    libubootenv-bin \
"

#    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", "graphics-demos", "", d)} 
#     gstreamer1.0-plugins-base 
#     gstreamer1.0-plugins-good 

# !! YIKES !!
SUMMARY_${PN}-screen = "EMAC OE Screen Packages."
RRECOMMENDS_${PN}-screen = " \
    psplash \
    fbset \
    fbida \
"

SUMMARY_${PN}-can = "EMAC OE CAN Packages."
RRECOMMENDS_${PN}-can = " can-utils "

SUMMARY_${PN}-pci = "EMAC OE PCI Packages."
RRECOMMENDS_${PN}-pci = " pciutils "

SUMMARY_${PN}-rt = "EMAC OE RT Packages."
RRECOMMENDS_${PN}-rt = " \
    rt-tests \
    hwlatdetect \
"
