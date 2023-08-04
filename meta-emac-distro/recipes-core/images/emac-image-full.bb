SUMMARY = "${DESCRIPTION}"
DESCRIPTION = "A console-only server image with more full-featured Linux system \
functionality installed, and the emac user."
LICENSE = "MIT"

require emac-image-core.bb

IMAGE_INSTALL:append = ""
