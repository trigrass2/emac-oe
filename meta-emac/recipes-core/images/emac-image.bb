require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "Headless development image from which other EMAC images will be extended."

IMAGE_INSTALL:append = " \
    packagegroup-emac-extras \
"

QB_OPT_APPEND = "-nographic"
QB_MEM = "-m 128"
QB_DEFAULT_FSTYPE = "ext4"

## Python local code
TEST_SUITES ?= "emac_echo"
