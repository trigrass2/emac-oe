PREFERRED_PROVIDER_virtual/kernel ?= "linux-fslc-imx"
PREFERRED_VERSION_linux-fslc-imx ?= "5.15%"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-fslc"

require conf/machine/include/imx-base.inc

# Essential for booting the board
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:append = " \
    kernel-image \
    kernel-devicetree \
    ${@bb.utils.contains('KERNEL_DEVICETREE_BUNDLE','1', 'kernel-image-zimage-bundle','',d)} \
"
KERNEL_DEVICETREE_BUNDLE = "1"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:append = " ${PREFERRED_PROVIDER_virtual/bootloader}"

MACHINE_FEATURES:append = " arm mtd "

IMX_DEFAULT_BSP = "nxp"

IMX_DEFAULT_KERNEL = "linux-fslc-imx"

KERNEL_IMAGETYPE = "zImage"

IMX_DEFAULT_BOOTLOADER = "u-boot-fslc"
UBOOT_SUFFIX:pn-u-boot-fslc = "img"

SERIAL_CONSOLES = "115200;ttymxc1"
IMAGE_FSTYPES ?= "tar.gz"


