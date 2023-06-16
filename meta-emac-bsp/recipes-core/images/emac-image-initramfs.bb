require recipes-core/images/core-image-minimal-initramfs.bb
INITRAMFS_SCRIPTS:arm = "\
                      initramfs-framework-base \
                      initramfs-module-setup-live \
                      initramfs-module-e2fs \
                      initramfs-module-nfsrootfs \
                      initramfs-module-rootfs \
                     "
export IMAGE_BASENAME = "${MLPREFIX}emac-image-initramfs"
