MACHINE_FEATURES = " \
    acpi \
    alsa \
    bluetooth \
    efi \
    keyboard \
    pci \
    pcbios \
    screen \
    serial \
    usbgadget \
    usbhost \
    wifi \
"

## GLIB 
GLIBC_ADDONS = "nptl"

## KERNEL
PREFERRED_PROVIDER:virtual/kernel ?= "linux-emac"
REFERRED_VERSION:linux-emac ?= "5.10%"

#PREFERRED_PROVIDER:virtual/kernel ?= "linux-mainline"
#PREFERRED_VERSION:linux-emac ?= "5.15%"

KERNEL_IMAGETYPE ?= "bzImage"
EMAC_LINUX_VERSION_EXTENSION = "_${EMAC_LINUX_VERSION}${MACHINE_NUMBER}X${KERNEL_REV}.bzimg"

MACHINE_EXTRA_RRECOMMENDS:append = " \
    kernel-modules \
    linux-firmware \
"

## BOOTLOADER 
PREFERRED_PROVIDER:virtual/bootloader ?= "grub-efi"
MACHINE_EXTRA_RDEPENDS:append = " \
    grub-efi \
    efibootmgr \
"

## SERIAL 
SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLES_CHECK = "ttyS0"

MACHINEOVERRIDES ??= "x86"
include conf/machine/include/x86/x86-base.inc

## IMAGE
IMAGE_FSTYPES = "tar.gz wic wic.bmap iso live"
WKS_FILE = "x86.wks.in"
do_image_wic[depends] += "gptfdisk-native:do_populate_sysroot"
do_image_wic[recrdeptask] += "do_bootimg"
