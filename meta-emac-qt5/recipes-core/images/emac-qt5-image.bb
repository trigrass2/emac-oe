require recipes-core/images/emac-image.bb
DESCRIPTION = "Qt5 Image extends emac-image."

IMAGE_FSTYPES ?= " ext4 tar.gz"
IMAGE_INSTALL:append = " \
    packagegroup-emac-qt5 \
"

IMAGE_TYPE = "Qt 5 Embedded"
BUILD_TYPE = "qt5"
FS_NUMBER = "02"

## SDK
# include recipes-core/meta/meta-toolchain-emac-qt5.bb
