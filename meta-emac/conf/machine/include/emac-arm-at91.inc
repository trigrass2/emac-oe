PREFERRED_PROVIDER_virtual/kernel ?= "linux-emac-at91"
PREFERRED_VERSION_linux-emac-at91 ?= "3.10%"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-emac-at91"

PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
XSERVER ?= "xserver-xorg \
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

MACHINE_FEATURES += "usbhost serial usbgadget"
MACHINE_EXTRA_RDEPENDS += "u-boot-fw-utils"
EXTRA_IMAGEDEPENDS += "u-boot-emac-at91 at91bootstrap"

SERIAL_CONSOLE ?= "115200 ttyS0"

KERNEL_IMAGETYPE ?= "zImage"

EMAC_LINUX_VERSION_EXTENSION ?= "_${EMAC_LINUX_VERSION}X${SOM_NUMBER}A${KERNEL_REV}.zimg"
EMAC_UBOOT_LOCALVERSION ?= "_${EMAC_UBOOT_VERSION}0${SOM_NUMBER}A${UBOOT_REV}.ubin"
EMAC_BOOTSTRAP_LOCALVERSION ?= "_${EMAC_BOOTSTRAP_VERSION}0${SOM_NUMBER}A${BOOTSTRAP_REV}.bin"

UBOOT_ENTRYPOINT ?= "0x70008000"
UBOOT_MACHINE ?= "som9x25_config"

IMAGE_FSTYPES ?= "tar.gz"
