#
# Base machine settings for X86 architecture BSPs
#

PREFERRED_PROVIDER_virtual/kernel ?= "linux-emac-x86"
PREFERRED_VERSION_linux-emac-x86 ?= "3.19%"

PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"
XSERVER ?= "${XSERVER_X86_BASE} \
            ${XSERVER_X86_EXT} \
            ${XSERVER_X86_I915} \
            ${XSERVER_X86_I965} \
            ${XSERVER_X86_FBDEV} \
            ${XSERVER_X86_VESA} \
            ${XSERVER_X86_MODESETTING} \
            ${XSERVER_X86_TOUCH} \
           "

MACHINE_FEATURES += "screen pci usbhost x86 \
                     serial usbgadget sound bigflash "

BAD_RECOMMENDATIONS += " linux-firmware "

KERNEL_IMAGETYPE ?= "bzImage"
IMAGE_FSTYPES ?= "tar.gz"

SERIAL_CONSOLE ?= "115200 ttyS0"

COMBO_NUMBER = "1${MACHINE_NUMBER}${REV}"
EMAC_LINUX_VERSION_EXTENSION = "_SL400-XKN-${COMBO_NUMBER}.000"
PART_NUMBER = "SL050-XFN-${COMBO_NUMBER}.000"

#
# XSERVER subcomponents, used to build the XSERVER variable
#
XSERVER_X86_BASE = "xserver-xorg \
           xf86-input-mouse \
           xf86-input-keyboard \
           xf86-input-evdev \
           xf86-input-synaptics \
           "

XSERVER_X86_EXT = " \
           ${@base_contains('DISTRO_FEATURES', 'opengl', 'xserver-xorg-extension-glx', '', d)} \
           xserver-xorg-module-libint10 \
           "

XSERVER_X86_I915 = "xf86-video-intel \
           ${@base_contains('DISTRO_FEATURES', 'opengl', 'mesa-driver-i915', '', d)} \
           "

XSERVER_X86_I965 = "xf86-video-intel \
           ${@base_contains('DISTRO_FEATURES', 'opengl', 'mesa-driver-i965', '', d)} \
           "

XSERVER_X86_VESA = "xf86-video-vesa"

XSERVER_X86_FBDEV = "xf86-video-fbdev"

XSERVER_X86_TOUCH = " \
           ${@base_contains('MACHINE_FEATURES', 'touch', 'xf86-input-tslib', '', d)} \
           "

XSERVER_X86_MODESETTING = "xf86-video-modesetting"
