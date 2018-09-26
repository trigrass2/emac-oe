# A image used to populate the toolchain
LICENSE="CLOSED"

TOOLCHAIN_TARGET_TASK_append = " packagegroup-emac-toolchain-target"

require recipes-qt/meta/meta-toolchain-qt5.bb
