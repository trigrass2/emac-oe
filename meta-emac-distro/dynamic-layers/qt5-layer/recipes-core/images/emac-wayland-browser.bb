DESCRIPTION = "Image that has custom browser from emac along with various intel software"

require recipes-core/images/emac-image-qt5.bb

IMAGE_INSTALL:append = " \
    lightbrowser \
    qtwebengine \
    ca-certificates \
"
