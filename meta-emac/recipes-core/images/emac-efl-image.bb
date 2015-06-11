require recipes-core/images/emac-image.bb

DESCRIPTION = "An Enlightenment illume desktop image"

IMAGE_INSTALL += "\
    packagegroup-x11-illume \
    matchbox-terminal \
    xscreensaver \
    xscreensaver-demo \
    emac-enlightenment \
    xserver-xf86-config \
    liberation-fonts \
    xkbcomp \
    xkeyboard-config \
    libegl-mesa \
    libgles2-mesa \
    equate \
"

IMAGE_TYPE = "Enlightenment X11 Desktop"
BUILD_TYPE = "e18"

PART_NUMBER = "enlightenment"
