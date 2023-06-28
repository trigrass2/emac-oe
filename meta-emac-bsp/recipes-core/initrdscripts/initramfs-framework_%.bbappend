# Skipping busybox recipe in emac distro causes failures to build this
FILESEXTRAPATHS:prepend:emac := "${THISDIR}/${BPN}:"

PACKAGES:remove:emac = "initramfs-module-mdev"

do_install:append:emac(){
    rm ${D}/init.d/01-mdev
}