DESCRIPTION = "EMACS Host packages for a embedded Qt5 image"
LICENSE = "CLOSED"
PR = "r0"

inherit packagegroup nativesdk

MACHINE_EXTRA_INSTALL_SDK_HOST ?= ""

PACKAGE_ARCH = "${SDK_ARCH}"

RDEPENDS:${PN}:append = " \
    nativesdk-packagegroup-sdk-host \
    nativesdk-packagegroup-qt5-toolchain-host \
    nativesdk-cmake \
    nativesdk-make \
    nativesdk-ninja \
    nativesdk-python3-modules \
    nativesdk-python3-misc \
    nativesdk-qt3d-tools \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', ' nativesdk-wayland-dev nativesdk-qtwayland-tools ', '' , d)} \
    ${MACHINE_EXTRA_INSTALL_SDK_HOST} \
"


