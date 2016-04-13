PREFERRED_PROVIDER_virtual/kernel = "linux-emac-at91"
PREFERRED_VERSION_linux-emac-at91 ?= "3.10%"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac-at91"

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

MACHINE_FEATURES += "usbhost apm serial usbgadget"
MACHINE_EXTRA_RDEPENDS += "u-boot-fw-utils"
EXTRA_IMAGEDEPENDS += "u-boot-emac-at91 at91bootstrap"

SERIAL_CONSOLE ?= "115200 ttyS0"

KERNEL_IMAGETYPE ?= "zImage"

COMBO_NUMBER = "${CARRIER_NUMBER}${SOM_NUMBER}${REV}"
EMAC_LINUX_VERSION_EXTENSION = "_${EMAC_LINUX_VERSION}-X${COMBO_NUMBER}.000"
EMAC_UBOOT_LOCALVERSION = "_${EMAC_UBOOT_VERSION}-X${COMBO_NUMBER}.000"
PART_NUMBER = "SL050-AFN-${FS_NUMBER}${COMBO_NUMBER}.000"

UBOOT_ENTRYPOINT ?= "0x70008000"
UBOOT_MACHINE ?= "som9x25_config"

IMAGE_FSTYPES ?= "tar.gz"
