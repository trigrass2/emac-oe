require recipes-core/images/emac-image-full.bb
DESCRIPTION = "Qt5 Image extends emac-image-full."

inherit populate_sdk_qt5

IMAGE_INSTALL:append = " \
    packagegroup-emac-qt5 \
"
