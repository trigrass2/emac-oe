require linux-xenomai.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KBRANCH = "stable/4.14.85-arm_lan743x_ksz9477"
SRCREV = "1a22da01b132df823febe94626f0643b30c2f1e3"

SRC_URI += " \
    git://git@git.emacinc.com/linux-kernel/xenomai.git;branch=${KBRANCH};protocol=ssh \
    file://0001-null-evtdev-check.patch \
    file://0002-write-once-last-tsc.patch \
"

LINUX_VERSION = "4.14.85-ipipe"

EMAC_LINUX_VERSION = "SL414-00S"
PV = "${LINUX_VERSION}"
FIRST_SRCREV = "${@'${SRCREV}'[:10]}"
LINUX_VERSION_EXTENSION = "${EMAC_LINUX_VERSION_EXTENSION}+${FIRST_SRCREV}"
