PR = "r37"
UBOOT_GIT_URI = "git://git@git.emacinc.com/bootloader/ti-u-boot.git"
UBOOT_GIT_PROTOCOL = "ssh"
SRC_URI = "${UBOOT_GIT_URI};protocol=${UBOOT_GIT_PROTOCOL};branch=${BRANCH}"

BRANCH = "ti-u-boot-2020.01-som5728"
SRCREV = "dd1c83cbcf50d495092a1e09c7ad12d9a74a431a"
