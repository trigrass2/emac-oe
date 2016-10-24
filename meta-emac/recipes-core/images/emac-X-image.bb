require emac-image.bb

DESCRIPTION = "A very basic X11 image with a terminal"

IMAGE_INSTALL += "\
    packagegroup-core-x11 \
    matchbox-terminal \
    xserver-xf86-config \
    liberation-fonts \
    xkbcomp \
    xkeyboard-config \
    libegl-mesa \
    libgles2-mesa \
"

IMAGE_TYPE = "X11 Basic"
BUILD_TYPE = "x11"

PART_NUMBER = "x windows"
