PREFERRED_PROVIDER_virtual/kernel = "linux-emac-imx6"
PREFERRED_VERSION_linux-emac-imx6 ?= "4.4%"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac"

PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
XSERVER ?= "xserver-xorg \
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

MACHINE_FEATURES += "screen pci usbhost apm sound serial touch usbgadget can"
MACHINE_EXTRA_RDEPENDS += "u-boot-fw-utils"
EXTRA_IMAGEDEPENDS += "u-boot-emac"

SERIAL_CONSOLE ?= "115200 ttymxc1"

KERNEL_IMAGETYPE ?= "zImage"

COMBO_NUMBER = "${CARRIER_NUMBER}${SOM_NUMBER}${REV}"
EMAC_LINUX_VERSION_EXTENSION = "_${EMAC_LINUX_VERSION}-X${COMBO_NUMBER}.000"
EMAC_UBOOT_LOCALVERSION = "_${EMAC_UBOOT_VERSION}-X${COMBO_NUMBER}.000"
PART_NUMBER = "SL050-AFN-${FS_NUMBER}${COMBO_NUMBER}.000"

UBOOT_SUFFIX = "imx"
UBOOT_MACHINE ?= "somimx6dq_config"

IMAGE_FSTYPES ?= "tar.gz"