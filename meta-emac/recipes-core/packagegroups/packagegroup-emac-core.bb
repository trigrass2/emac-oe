#
# Copyright (C) 2016  EMAC Inc, All rights reserved
#

DESCRIPTION = "EMAC Core Package Groups"
LICENSE = "GPLv2"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = " \
    packagegroup-emac-core \
    packagegroup-emac-core-util \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", "packagegroup-emac-core-x86", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", "packagegroup-emac-core-touch", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "packagegroup-emac-core-wifi", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", 'sound', 'packagegroup-emac-core-sound', '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", "packagegroup-emac-core-mtd", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "screen", "packagegroup-emac-core-screen", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "packagegroup-emac-core-can", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "packagegroup-emac-core-pci", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "rt", "packagegroup-emac-core-rt", "", d)} \
    "

RRECOMMENDS_packagegroup-emac-core = "\
    packagegroup-emac-core-util \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", "packagegroup-emac-core-x86", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", "packagegroup-emac-core-touch", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "packagegroup-emac-core-wifi", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", 'sound', 'packagegroup-emac-core-sound', '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", "packagegroup-emac-core-mtd", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "screen", "packagegroup-emac-core-screen", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "packagegroup-emac-core-can", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "packagegroup-emac-core-pci", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "rt", "packagegroup-emac-core-rt", "", d)} \
    "

SUMMARY_packagegroup-emac-core-util = "EMAC OE Core Utilities"
RRECOMMENDS_packagegroup-emac-core-util = "\
    bash \
    udev-extraconf \
    kernel-modules \
    ifplugd \
    ntp \
    opkg \
    e2fsprogs \
    e2fsprogs-tune2fs \
    usbutils \
    eudev-hwdb \
    sudo \
    rsync \
    "

SUMMARY_packagegroup-emac-core-touch = "EMAC OE Touch Utilities"
RRECOMMENDS_packagegroup-emac-core-touch = "\
    tslib-calibrate \
    tslib-conf \
    tslib-tests \
    tslib \
    "

SUMMARY_packagegroup-emac-core-wifi = "EMAC OE Wifi Utilities"
RRECOMMENDS_packagegroup-emac-core-wifi = "\
    iw \
    wpa-supplicant \
    wireless-tools \
    bluez5 \
    "

SUMMARY_packagegroup-emac-core-sound = "EMAC OE ALSA Utilities"
RRECOMMENDS_packagegroup-emac-core-sound = "\
    alsa-utils-alsamixer \
    alsa-utils-midi \
    alsa-utils-aplay \
    alsa-utils-amixer \
    alsa-utils-speakertest \
    alsa-utils-alsaloop \
    alsa-utils-alsactl \
    alsa-state \
    mpg123 \
    libltdl \
    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", "audio-demos", "", d)} \
    "

SUMMARY_packagegroup-emac-core-mtd = "EMAC OE MTD Utilities"
RRECOMMENDS_packagegroup-emac-core-mtd = "\
    mtd-utils \
    mtd-utils-jffs2 \
    "

SUMMARY_packagegroup-emac-core-x86= "EMAC OE x86 Packages."
RRECOMMENDS_packagegroup-emac-core-x86 = "\
    grub \
    "

SUMMARY_packagegroup-emac-core-screen= "EMAC OE Screen Packages."
RRECOMMENDS_packagegroup-emac-core-screen = "\
    fbsplash \
    fbset \
    fbida \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", "graphics-demos", "", d)} \
    "

SUMMARY_packagegroup-emac-core-can= "EMAC OE CAN Packages."
RRECOMMENDS_packagegroup-emac-core-can = "\
    canutils \
    "

SUMMARY_packagegroup-emac-core-pci= "EMAC OE PCI Packages."
RRECOMMENDS_packagegroup-emac-core-pci = "\
    pciutils \
    "

SUMMARY_packagegroup-emac-core-rt= "EMAC OE RT Packages."
RRECOMMENDS_packagegroup-emac-core-rt = "\
    rt-tests \
    hwlatdetect \
    "
