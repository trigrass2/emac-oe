MACHINEOVERRIDES =. "sama5:sama5d3:"

KERNEL_IMAGETYPE ?= "zImage"
KERNEL_DEVICETREE_BUNDLE ?= "1"

AT91BOOTSTRAP_MACHINE ?= "${MACHINE}"
UBOOT_MACHINE ?= "soma5d35_spiflash_config"

require conf/machine/include/sama5d3.inc

PREFERRED_PROVIDER_virtual/kernel:sama5 = "linux-emac"
PREFERRED_PROVIDER_virtual/kernel = "linux-emac"
PREFERRED_VERSION_linux-emac:sama5 = "4.19%"
PREFERRED_VERSION_linux-emac = "4.19%"
PREFERRED_PROVIDER_virtual/bootloader:sama5 = "u-boot-emac"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-emac"
PREFERRED_PROVIDER_u-boot:sama5 = "u-boot-emac"
PREFERRED_PROVIDER_u-boot = "u-boot-emac"
PREFERRED_VERSION_at91bootstrap = "v3.9.3+gitAUTOINC+4a055866e2"
EXTRA_IMAGEDEPENDS:remove = "at91bootstrap-sam-ba"

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

MACHINE_FEATURES:prepend = " arm mtd "
SERIAL_CONSOLE ?= "115200 ttyS0"

IMAGE_FSTYPES ?= "tar.gz"
