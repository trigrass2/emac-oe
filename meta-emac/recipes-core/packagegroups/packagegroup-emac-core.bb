#
# Copyright (C) 2016  EMAC Inc, All rights reserved
#

DESCRIPTION = "EMAC Core Package Groups"
LICENSE = "GPLv2"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
RDEPENDS_packagegroup-emac-core = "${MACHINE_EXTRA_RDEPENDS}"

PACKAGES = " \
    packagegroup-emac-core \
    packagegroup-emac-core-util \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", "packagegroup-emac-core-x86", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "arm", "packagegroup-emac-core-arm", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "touchscreen", "packagegroup-emac-core-touch", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "wifi", "packagegroup-emac-core-wifi", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", 'sound', 'packagegroup-emac-core-sound', '',d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mtd", "packagegroup-emac-core-mtd", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "screen", "packagegroup-emac-core-screen", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "can", "packagegroup-emac-core-can", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", "packagegroup-emac-core-pci", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "rt", "packagegroup-emac-core-rt", "", d)} \
    "

RRECOMMENDS_packagegroup-emac-core = " \
    packagegroup-emac-core-util \
    ${@bb.utils.contains("MACHINE_FEATURES", "x86", "packagegroup-emac-core-x86", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "arm", "packagegroup-emac-core-arm", "", d)} \
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
#    eudev-hwdb
RRECOMMENDS_packagegroup-emac-core-util = " \
    bash \
    e2fsprogs \
    e2fsprogs-tune2fs \
    kernel-modules \
    kernel-base \
    ifplugd \
    ntp \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "rpm", " dnf rpm ", "", d)} \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "ipk", " opkg ", "", d)} \
    ${@bb.utils.contains("EMAC_PACKAGEMANAGER", "deb", " apt ", "", d)} \
    libgpiod \
    libgpiod-tools \
    openssh \
    rsync \
    sudo \
    sysfsutils \
    tzcode \
    usbutils \
    udev-extraconf \
    util-linux-mount \
"

SUMMARY_packagegroup-emac-core-touch = "EMAC OE Touch Utilities"
RRECOMMENDS_packagegroup-emac-core-touch = " \
    tslib-calibrate \
    tslib-conf \
    tslib-tests \
    tslib \
"

SUMMARY_packagegroup-emac-core-wifi = "EMAC OE Wifi Utilities"
RRECOMMENDS_packagegroup-emac-core-wifi = " \
    iw \
    wpa-supplicant \
    wireless-tools \
    bluez5 \
"

SUMMARY_packagegroup-emac-core-sound = "EMAC OE ALSA Utilities"
RRECOMMENDS_packagegroup-emac-core-sound = "\
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-alsamixer ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-midi ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-aplay ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-amixer ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-speakertest ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-alsaloop ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-utils-alsactl ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "alsa", " alsa-state ", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "pulseaudio", " pulseaudio-server pulseaudio-misc ", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", " audio-demos ", "", d)} \
    mpg123 \
    libltdl \
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

SUMMARY_packagegroup-emac-core-arm= "EMAC OE arm Packages."
RRECOMMENDS_packagegroup-emac-core-arm = "\
    serial-control \
    apm \
    libubootenv-bin \
    kernel-devicetree \
"

SUMMARY_packagegroup-emac-core-screen= "EMAC OE Screen Packages."
RRECOMMENDS_packagegroup-emac-core-screen = "\
    psplash \
    fbset \
    fbida \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    ${@bb.utils.contains("MACHINE_FEATURES", "bigflash", "graphics-demos", "", d)} \
"

SUMMARY_packagegroup-emac-core-can= "EMAC OE CAN Packages."
RRECOMMENDS_packagegroup-emac-core-can = "\
    can-utils \
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
