require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "Headless development image from which other EMAC images will be extended."

IMAGE_INSTALL:append = " \
    packagegroup-emac-extras \
"

