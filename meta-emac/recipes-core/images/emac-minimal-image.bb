require emac.inc

DESCRIPTION = "Headless base image from which other EMAC images will be extended."

IMAGE_INSTALL += " \
	packagegroup-core-boot \
	packagegroup-emac-core \
    "
