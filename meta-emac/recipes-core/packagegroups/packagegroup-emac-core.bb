#
# Copyright (C) 2014  EMAC Inc, All rights reserved
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
    ${@bb.utils.contains("MACHINE_FEATURES", "touch", "packagegroup-emac-core-touch", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "packagegroup-emac-core-wifi", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", 'sound', 'packagegroup-emac-core-sound', '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", "packagegroup-emac-core-mtd", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "screen", "packagegroup-emac-core-screen", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "packagegroup-emac-core-can", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "usbhost", "packagegroup-emac-core-usb", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "packagegroup-emac-core-pci", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "apm", "packagegroup-emac-core-apm", "", d)} \
    "

RDEPENDS_packagegroup-emac-core = "\
    packagegroup-emac-core-util \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", "packagegroup-emac-core-x86", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "touch", "packagegroup-emac-core-touch", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "packagegroup-emac-core-wifi", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", 'sound', 'packagegroup-emac-core-sound', '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", "packagegroup-emac-core-mtd", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "screen", "packagegroup-emac-core-screen", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "packagegroup-emac-core-can", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "usbhost", "packagegroup-emac-core-usb", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "packagegroup-emac-core-pci", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "apm", "packagegroup-emac-core-apm", "", d)} \
    "

SUMMARY_packagegroup-emac-core-util = "EMAC OE Core Utilities"
RDEPENDS_packagegroup-emac-core-util = "\
    bash \
    udev-extraconf \
    kernel-modules \   
    ifplugd \
    ntp \
    opkg \
    busybox-syslog \
    busybox-udhcpc \
    e2fsprogs \
    emac-feed-config \
    "	

SUMMARY_packagegroup-emac-core-touch = "EMAC OE Touch Utilities"
RDEPENDS_packagegroup-emac-core-touch = "\
    tslib-calibrate \
    tslib-conf \
    tslib-tests \
    tslib \
    "

SUMMARY_packagegroup-emac-core-wifi = "EMAC OE Wifi Utilities"
RDEPENDS_packagegroup-emac-core-wifi = "\
    iw \
    wpa-supplicant \
    wireless-tools \
    "

SUMMARY_packagegroup-emac-core-sound = "EMAC OE ALSA Utilities"
RDEPENDS_packagegroup-emac-core-sound = "\
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
RDEPENDS_packagegroup-emac-core-mtd = "\
    mtd-utils \
    mtd-utils-jffs2 \
    "

SUMMARY_packagegroup-emac-core-x86= "EMAC OE x86 Packages."
RDEPENDS_packagegroup-emac-core-x86 = "\
    lilo \
    "

SUMMARY_packagegroup-emac-core-screen= "EMAC OE Screen Packages."
RDEPENDS_packagegroup-emac-core-screen = "\
    fbsplash \
    fbset \
    fbida \
    graphics-demos \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", "graphics-demos", "", d)} \
    "

SUMMARY_packagegroup-emac-core-can= "EMAC OE CAN Packages."
RDEPENDS_packagegroup-emac-core-can = "\
    canutils \
    "

SUMMARY_packagegroup-emac-core-usb= "EMAC OE USB Packages."
RDEPENDS_packagegroup-emac-core-usb = "\
    usbutils \
    "

SUMMARY_packagegroup-emac-core-pci= "EMAC OE PCI Packages."
RDEPENDS_packagegroup-emac-core-pci = "\
    pciutils \
    "

SUMMARY_packagegroup-emac-core-apm= "EMAC OE APM Packages."
RDEPENDS_packagegroup-emac-core-apm = "\
    apm \
    apmd \
    "
