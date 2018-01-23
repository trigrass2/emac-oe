PREFERRED_PROVIDER_virtual/kernel ?= "linux-emac"
PREFERRED_VERSION_linux-emac ?= "4.9%"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-emac"


PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
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

MACHINE_FEATURES += "screen usbhost sound serial touch usbgadget can"
MACHINE_EXTRA_RDEPENDS += "u-boot-fw-utils"
EXTRA_IMAGEDEPENDS += "u-boot-emac"

SERIAL_CONSOLE ?= "115200 ttyO0"

KERNEL_IMAGETYPE ?= "zImage"

EMAC_LINUX_VERSION_EXTENSION = "_${EMAC_LINUX_VERSION}-X${SOM_NUMBER}A${KERNEL_REV}.zimg"

UBOOT_ENTRYPOINT ?= "0x80008000"
UBOOT_MACHINE ?= "am3517_evm_config"

IMAGE_FSTYPES ?= "tar.gz"
