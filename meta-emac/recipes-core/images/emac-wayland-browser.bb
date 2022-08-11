DESCRIPTION = "Image that has custom browser from emac along with various intel software"

require recipes-core/images/emac-qt5-image.bb

IMAGE_INSTALL:append = " \
    grub-efi grub efibootmgr \
    lightbrowser qtwebengine ca-certificates \
    weston weston-init \
    \
    libgl-mesa libgles1-mesa libgles2-mesa libgles3-dev \
    libegl-mesa libosmesa libglapi glfw glew libglu freeglut \
    \
    libgles3-mesa-dev \
    \
    linux-firmware-i915 linux-firmware-iwlwifi \
    gstreamer1.0-vaapi libva libva-utils intel-vaapi-driver \
    thermald \
    intel-media-driver intel-mediasdk \
    mesa-driver-i915 \
    \
    packagegroup-core-x11 \
    xserver-xf86-config \
    liberation-fonts \
    xkbcomp \
    xkeyboard-config \
"

change_hostname () {
    echo "Emac-SL" > ${IMAGE_ROOTFS}/${sysconfdir}/hostname
}

ROOTFS_POSTPROCESS_COMMAND += "change_hostname;"
PART_NUMBER = "SL054-01LS10-002.tgz"

