SUMMARY = "Headless server image intended for recovery."
DESCRIPTION = "\
A console-only server image, bare minimum to boot to a linux prompt. \
Ideally an initram disk would be made from this image."
LICENSE = "MIT"

IMAGE_FEATURES += " debug-tweaks ssh-server-openssh"

IMAGE_INSTALL:append = "\
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

inherit core-image

