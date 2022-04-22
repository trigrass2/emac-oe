require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "SDK Image extends emac-qt4-image with SDK packages"

IMAGE_FEATURES:append = " dev-pkgs "
PACKAGE_EXCLUDE = "linux-dummy-dev lighttpd linux-firmware kernel-modules packagegroup-core-boot"

IMAGE_INSTALL:append = " \
    packagegroup-qte-toolchain-target \
    xenomai-3 \
    libusb1 \
    confuse \
    xmlrpc-c \
    libmodbus \
    boost \
"

IMAGE_TYPE = "SDK"
BUILD_TYPE = "sdk"
PART_NUMBER ?= "Standard SDK"

fix_mkspecs() {
	sed -i -e "s|^OE_SYSROOT.*$|OE_SYSROOT              = $\(HOME\)/EMAC-SDK/sysroots/armv5e|" ${IMAGE_ROOTFS}${datadir}/qtopia/mkspecs/armv5e-emac-linux-gnueabi-g++/qmake.conf
	sed -i -e "s|^OE_SYSROOT.*$|OE_SYSROOT              = $\(HOME\)/EMAC-SDK/sysroots/armv7a|" ${IMAGE_ROOTFS}${datadir}/qtopia/mkspecs/armv7a-emac-linux-gnueabi-g++/qmake.conf
	sed -i -e "s|^OE_SYSROOT.*$|OE_SYSROOT              = $\(HOME\)/EMAC-SDK/sysroots/i586|" ${IMAGE_ROOTFS}${datadir}/qtopia/mkspecs/i586-emac-linux-g++/qmake.conf
	sed -i -e "s|^OE_SYSROOT.*$|OE_SYSROOT              = $\(HOME\)/EMAC-SDK/sysroots/core2|" ${IMAGE_ROOTFS}${datadir}/qtopia/mkspecs/core2-emac-linux-g++/qmake.conf
}

ROOTFS_POSTPROCESS_COMMAND:append = " fix_mkspecs; "
