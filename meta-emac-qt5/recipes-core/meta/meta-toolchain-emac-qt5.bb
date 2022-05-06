DESCRIPTION = "Emac Qt5 Development SDK"
LICENSE = "MIT"

inherit populate_emacqt5_qt5_sdk

TOOLCHAIN_HOST_TASK:append = " \
    nativesdk-packagegroup-emac-qt5-toolchain-host \
"

TOOLCHAIN_TARGET_TASK:append = " \
    packagegroup-emac-qt5-toolchain-target \
"

SDKIMAGE_FEATURES:append = " dev-pkgs"
