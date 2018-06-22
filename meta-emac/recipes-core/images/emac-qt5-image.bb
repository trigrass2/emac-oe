require recipes-core/images/emac-image.bb

DESCRIPTION = "Qt5 Image extends emac-image."

IMAGE_INSTALL_append = " \
	packagegroup-emac-qt5 \
	"

IMAGE_TYPE = "Qt 5 Embedded"
BUILD_TYPE = "qt5"
FS_NUMBER = "01"
