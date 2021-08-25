DESCRIPTION = "Emac Qt5 Development SDK"
LICENSE = "CLOSED"

inherit populate_emacqt5_qt5_sdk

## 4969 tasks
TOOLCHAIN_HOST_TASK_append += " \
    nativesdk-packagegroup-emac-qt5-toolchain-host \
"

TOOLCHAIN_TARGET_TASK_append += " \
    packagegroup-emac-qt5-toolchain-target \
"

SDKIMAGE_FEATURES_append += " dev-pkgs"
