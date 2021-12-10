PREFERRED_PROVIDER_virtual/kernel ?= "linux-emac"
PREFERRED_VERSION_linux-emac ?= "4.19%"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-emac"
PREFERRED_VERSION_u-boot-emac ?= "v2020.04%"

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"

XSERVER = "\
    xserver-xorg \
    xserver-xorg-extension-dri2 \
    xserver-xorg-extension-glx \
    xserver-xorg-extension-extmod \
    xserver-xorg-extension-dbe \
    xf86-input-evdev \
    xf86-input-mouse \
    xf86-video-omapfb \
    xf86-video-fbdev \
    xf86-input-keyboard \
    xf86-input-tslib \
"

MACHINE_FEATURES += "arm"
SERIAL_CONSOLE ?= "115200 ttyO0"
KERNEL_IMAGETYPE ?= "zImage"
UBOOT_MACHINE ?= "am3517_evm_config"
IMAGE_FSTYPES ?= "tar.gz"
