require emac.inc

DESCRIPTION = "Headless base image from which other EMAC images will be extended."

IMAGE_INSTALL_append = " \
	packagegroup-core-boot \
	packagegroup-emac-core \
    "
