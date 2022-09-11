require conf/machine/include/at91sam9.inc

# Essential for booting the board
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:append = " \
    kernel-image \
    kernel-devicetree \
    ${@bb.utils.contains('KERNEL_DEVICETREE_BUNDLE','1', 'kernel-image-zimage-bundle','',d)} \
"
KERNEL_DEVICETREE_BUNDLE = "1"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:append = " ${PREFERRED_PROVIDER_virtual/bootloader}"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:append = " at91bootstrap"

PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
XSERVER ?= " \
    xserver-xorg \
    xserver-xorg-extension-dri2 \
    xserver-xorg-extension-glx \
    xserver-xorg-extension-extmod \
    xserver-xorg-extension-dbe \
    xf86-input-mouse \
    xf86-input-keyboard \
    xf86-input-evdev \
    xf86-video-fbdev \
    xf86-input-tslib \
"

MACHINE_FEATURES:prepend = " arm "

SERIAL_CONSOLE ?= "115200 ttyS0"

KERNEL_IMAGETYPE ?= "zImage"

UBOOT_ENTRYPOINT ?= "0x70008000"
UBOOT_MACHINE ?= "som9x25_config"

IMAGE_FSTYPES ?= "tar.gz"

PREFERRED_PROVIDER_virtual/kernel = "linux-emac"
PREFERRED_VERSION_linux-emac = "4.9%"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac-at91"
