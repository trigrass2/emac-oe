require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "Headless development image from which other EMAC images will be extended."

IMAGE_INSTALL_append = " \
    packagegroup-emac-extras \
    ${@bb.utils.contains("MACHINE_FEATURES", "pci", " packagegroup-emac-core-pci ", "", d)} \
"

QB_OPT_APPEND = "-nographic"
QB_MEM = "-m 128"
QB_DEFAULT_FSTYPE = "ext4"

## Python local code
TEST_SUITES ?= "emac_echo"
