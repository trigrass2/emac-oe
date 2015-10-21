require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "Headless development image with xenomai from which other EMAC images will be extended."

PREFERRED_PROVIDER_virtual/linux-ipipe ?= "linux-xenomai"

DEPENDS_append = " ${PREFERRED_PROVIDER_virtual/linux-ipipe} "

IMAGE_INSTALL_append = " \
	packagegroup-emac-extras \
	xenomai-3 \
    "
