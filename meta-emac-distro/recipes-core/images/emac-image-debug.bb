SUMMARY = "${DESCRIPTION}"
DESCRIPTION = "A console-only server useful for debugging the hardware."
LICENSE = "MIT"

require emac-image-minimal.bb

CORE_IMAGE_EXTRA_INSTALL:append = " \
    packagegroup-base-extended \
    packagegroup-base-zeroconf \
    packagegroup-hw-test \
"
