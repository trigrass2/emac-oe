require emac.inc
inherit emac_utils

DESCRIPTION = "Headless base image from which other EMAC images will be extended."

MACHINE_EXTRA_RDEPENDS ?= ""
MACHINE_EXTRA_RRECOMMENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

IMAGE_FEATURES ?= ""

IMAGE_INSTALL_append = " \
    ${@bb.utils.contains("EMAC_SHELLMANAGER", "busybox", " packagegroup-core-boot ", " packagegroup-no-busybox ", d)} \
    ${VIRTUAL-RUNTIME_base-utils-syslog} \
    ${MACHINE_EXTRA_RDEPENDS} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    packagegroup-emac-core \
"
IMAGE_FEATURES += "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", " package-management ", "", d)}"


PACKAGE_FEED_URIS = "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", "http://ftp.emacinc.com/ota/${MACHINE}/${DISTRO_CODENAME}", "", d)}"
PACKAGE_FEED_BASE_PATHS = "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", "${EMAC_PACKAGEMANAGER}", "", d)}"
PACKAGE_FEED_ARCHS = "${@remove_duplicate_values(d, "PACKAGE_ARCHS", "ALL_MULTILIB_PACKAGE_ARCHS")}"
