require recipes-core/images/core-image-tiny-initramfs.bb
DESCRIPTION = "Emacs tiny image. Note one should use emac-tiny for a distro"

IMAGE_INSTALL:append = " \
    ${MACHINE_EXTRA_RRECOMMENDS} \
    ${MACHINE_EXTRA_RDEPENDS} \
"
