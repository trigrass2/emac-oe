# Machine configuration for core2-64(x86_64/i686)
# Default image for all atom based products

DEFAULTTUNE ?= "core2-64"
MACHINEOVERRIDES:prepend = "atom-sbc:"

include conf/machine/include/x86/emac-x86.inc
include conf/machine/include/x86/tune-core2.inc

MACHINE_FEATURES += " \
    atom-sbc \
"

PREFERRED_PROVIDER_libva = "libva-intel"
PREFERRED_PROVIDER_libva-native = "libva-intel-native"
PREFERRED_PROVIDER_nativesdk-libva = "nativesdk-libva-intel"

PREFERRED_PROVIDER_libva-utils = "libva-utils-intel"
PREFERRED_PROVIDER_libva-native = "libva-utils-intel-native"
PREFERRED_PROVIDER_nativesdk-libva-utils = "nativesdk-libva-utils-intel"

## intel based feature set 
MACHINE_EXTRA_RDEPENDS:append = " \
    grub-efi \
    grub \
    efibootmgr \
    \
    linux-firmware-i915 \
    linux-firmware-iwlwifi \
    \
    libva \
    libva-utils \
    intel-vaapi-driver \
    gstreamer1.0-vaapi \
    intel-media-driver \
    intel-mediasdk \
    libgles3-mesa-dev \
    thermald \
    ${@bb.utils.contains('EMAC_DISPLAY', 'x11', ' ${XSERVER} ', '', d )} \
    ${@bb.utils.contains('EMAC_DISPLAY_HW', 'opengl', ' mesa-driver-i915 ', '', d)} \
"
# kernel-module-i915 
# metee 


## Add with meta-intel
#MACHINE_EXTRA_RRECOMMENDS += " \
#    intel-vaapi-driver \
#    gstreamer1.0-vaapi \
#"

## BOOTLOADER
GRUB_TIMEOUT ?= "5"
#GRUB_GFXMODE = "1024x768x32"
#GRUB_COLOR_NORMAL="green/black"
#GRUB_COLOR_HIGHLIGHT="light-gray/light-magenta"

##UTILS


## MISC 
