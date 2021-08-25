DESCRIPTION = "EMACS Host packages for a embedded Qt5 image"
LICENSE = "CLOSED"
PR = "r0"

inherit nativesdk packagegroup

MACHINE_EXTRA_INSTALL_SDK_HOST ?= ""

RDEPENDS_${PN} += " \
    nativesdk-cmake \
    nativesdk-make \
    nativesdk-python3-modules \
    nativesdk-python3-misc \
    nativesdk-perl-modules \
    ${MACHINE_EXTRA_INSTALL_SDK_HOST} \
"

RDEPENDS_${PN} += " \
    nativesdk-qt3d-tools \
    nativesdk-qtbase \
    nativesdk-qtbase-dev \
    nativesdk-qtbase-staticdev \
    nativesdk-qtdeclarative-staticdev \
    nativesdk-qtdeclarative-tools \
    nativesdk-qtremoteobjects-tools \
    nativesdk-qtscxml-tools \
    nativesdk-qttools-tools \
    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "nativesdk-wayland-dev", "", d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-qtwayland-tools', '', d)} \
"
    
    
