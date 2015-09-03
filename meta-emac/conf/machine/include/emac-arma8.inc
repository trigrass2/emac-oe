PREFERRED_PROVIDER_virtual/kernel = "linux-emac-omap"
PREFERRED_VERSION_linux-emac-omap ?= "4.0%"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac-omap"


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

MACHINE_FEATURES += "screen usbhost apm sound serial touch usbgadget can"
MACHINE_EXTRA_RDEPENDS += "u-boot-fw-utils"
EXTRA_IMAGEDEPENDS += "u-boot-emac-omap"

SERIAL_CONSOLE ?= "115200 ttyO0"

KERNEL_IMAGETYPE ?= "zImage"

UBOOT_ENTRYPOINT ?= "0x80008000"
UBOOT_MACHINE ?= "am3517_evm_config"

IMAGE_FSTYPES ?= "tar.gz"





