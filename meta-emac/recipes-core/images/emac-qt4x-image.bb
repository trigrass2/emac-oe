require recipes-core/images/emac-image.bb

DESCRIPTION = "Qt4 Core GUI Image extends emac-image using qt4 packagegroups."

IMAGE_INSTALL_append  = " qt4-x11-free"

IMAGE_TYPE = "Qt 4 on X11"
BUILD_TYPE = "qt4X"
