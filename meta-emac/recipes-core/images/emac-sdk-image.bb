require recipes-core/images/emac-qt4e-image.bb

DESCRIPTION = "SDK Image extends emac-qt4-image with SDK packages"

IMAGE_FEATURES_append = "dev-pkgs"

IMAGE_INSTALL_append = " \
	xenomai-3 \
	"

IMAGE_TYPE = "SDK"
BUILD_TYPE = "sdk"
PART_NUMBER ?= "Standard SDK"
