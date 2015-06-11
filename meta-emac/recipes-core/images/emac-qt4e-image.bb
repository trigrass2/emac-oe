require recipes-core/images/emac-image.bb

DESCRIPTION = "Qt4e Image extends emac-image using qt4 embedded packagegroups."

IMAGE_INSTALL_append = " \
	packagegroup-emac-qt \
	"

PACKAGE_EXCLUDE = "qt4-embedded-demos-doc qt4-embedded-assistant qt4-embedded-examples qt4-embedded-mkspecs qt4-embedded-tools qt4-embedded-qt3to4"

IMAGE_TYPE = "Qt 4 Embedded"
BUILD_TYPE = "qt4e"
PART_NUMBER ?= "Standard QT"
