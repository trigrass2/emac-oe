require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "Headless development image from which other EMAC images will be extended."

IMAGE_INSTALL_append = " \
    packagegroup-emac-extras \
"
