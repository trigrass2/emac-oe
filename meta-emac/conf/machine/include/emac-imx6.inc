PREFERRED_PROVIDER_virtual/kernel ?= "linux-emac"
PREFERRED_VERSION_linux-emac ?= "4.9%"
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

MACHINE_FEATURES += "pci can wifi sound arm"
EXTRA_IMAGEDEPENDS += "u-boot-emac"

SERIAL_CONSOLE ?= "115200 ttymxc1"

KERNEL_IMAGETYPE ?= "zImage"

UBOOT_SUFFIX = "imx"
UBOOT_MACHINE ?= "somimx6dq1G_config"

IMAGE_FSTYPES ?= "tar.gz"

DEFAULTTUNE = "armv7a-neon"
