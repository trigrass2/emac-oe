PREFERRED_PROVIDER:virtual/kernel ?= "linux-emac"
PREFERRED_VERSION:linux-emac ?= "4.9%"
PREFERRED_PROVIDER:virtual/bootloader ?= "u-boot-emac-at91"

PREFERRED_PROVIDER:virtual/xserver ?= "xserver-xorg"
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

MACHINE_FEATURES:append = " arm "

SERIAL_CONSOLE ?= "115200 ttyS0"

KERNEL_IMAGETYPE ?= "zImage"

UBOOT_ENTRYPOINT ?= "0x70008000"
UBOOT_MACHINE ?= "som9x25_config"

IMAGE_FSTYPES ?= "tar.gz"
