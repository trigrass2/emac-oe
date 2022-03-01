require emac.inc

DESCRIPTION = "Headless base image from which other EMAC images will be extended."

MACHINE_EXTRA_RDEPENDS ?= ""
MACHINE_EXTRA_RRECOMMENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

IMAGE_INSTALL_append = " \
    ${@bb.utils.contains("EMAC_SHELLMANAGER", "busybox", " packagegroup-core-boot ", " packagegroup-no-busybox ", d)} \
    ${VIRTUAL-RUNTIME_base-utils-syslog} \
    ${MACHINE_EXTRA_RDEPENDS} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    packagegroup-emac-core \
"

