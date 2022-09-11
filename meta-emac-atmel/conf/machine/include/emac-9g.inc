## BOOTLOADER
AT91BOOTSTRAP_MACHINE ?= "som9x25"
UBOOT_MACHINE ?= "som9x25_config"
UBOOT_ENTRYPOINT ?= "0x70008000"
KERNEL_IMAGETYPE ?= "zImage"

require conf/machine/include/at91sam9.inc

MACHINE_FEATURES:prepend = " arm "

PREFERRED_PROVIDER_virtual/bootloader:sama5 = "u-boot-emac-at91"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac-at91"

PREFERRED_PROVIDER_u-boot:sama5 = "u-boot-emac-at91"

PREFERRED_PROVIDER_at91bootstrap = "at91bootstrap-emac"
PREFERRED_VERSION_at91bootstrap = "3.9.3%"

## KERNEL
PREFERRED_PROVIDER_virtual/kernel = "linux-emac"
PREFERRED_VERSION_linux-emac = "4.9%"

PREFERRED_PROVIDER_virtual/kernel:sama5 = "linux-emac"
PREFERRED_PROVIDER_virtual/kernel = "linux-emac"

PREFERRED_VERSION_linux-emac:sama5 = "4.9%"
PREFERRED_VERSION_linux-emac = "4.9%"

EXTRA_IMAGEDEPENDS:remove = "at91bootstrap-sam-ba"
EXTRA_IMAGEDEPENDS:append = " \
    u-boot-emac-at91 \
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

SERIAL_CONSOLE ?= "115200 ttyS0"
IMAGE_FSTYPES ?= "tar.gz"
