PREFERRED_PROVIDER_virtual/kernel =  "linux-emac"
PREFERRED_VERSION_linux-emac = "4.19%"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac"

include conf/machine/include/sama5d3.inc

EXTRA_IMAGEDEPENDS:append = " \
    u-boot-emac \
    at91bootstrap \ 
    linux-emac \
"

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

UBOOT_MACHINE ?= "soma5d35_spiflash_config"

IMAGE_FSTYPES ?= "tar.gz"
