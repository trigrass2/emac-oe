DESCRIPTION = "Image that has custom browser from emac along with various intel software"

require recipes-core/images/emac-qt5-image.bb

IMAGE_INSTALL:append = " \
    lightbrowser \
    qtwebengine \
    ca-certificates \
"

change_hostname () {
    echo "Emac-SL" > ${IMAGE_ROOTFS}/${sysconfdir}/hostname
}

ROOTFS_POSTPROCESS_COMMAND += "change_hostname;"


