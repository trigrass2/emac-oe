DESCRIPTION = "Emac Qt5 Development SDK"
LICENSE = "CLOSED"
inherit populate_sdk

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-emac-qt5-toolchain-host"
TOOLCHAIN_TARGET_TASK += "packagegroup-emac-qt5-toolchain-target"


