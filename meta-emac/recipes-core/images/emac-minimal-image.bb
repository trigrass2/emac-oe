require emac.inc
inherit emac_utils

DESCRIPTION = "Headless base image from which other EMAC images will be extended."

MACHINE_EXTRA_RDEPENDS ?= ""
MACHINE_EXTRA_RRECOMMENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""
VIRTUAL-RUNTIME_syslog ?= '${@bb.utils.contains("EMAC_SHELLMANAGER", "busybox", " ", " sysklogd ", d)}'

IMAGE_INSTALL:append = " \
    ${@bb.utils.contains("EMAC_SHELLMANAGER", "busybox", " packagegroup-core-boot ", " packagegroup-no-busybox ", d)} \
    ${VIRTUAL-RUNTIME_base-utils-syslog} \
    ${MACHINE_EXTRA_RDEPENDS} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    packagegroup-emac-core \
"
IMAGE_FEATURES:append = "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", " package-management ", "", d)}"

PACKAGE_FEED_URIS = "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", "http://10.0.3.188/repo/${DISTRO_CODENAME}", "", d)}"
PACKAGE_FEED_BASE_PATHS = "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", "${EMAC_PACKAGEMANAGER}", "", d)}"
#PACKAGE_FEED_ARCHS = "${@bb.utils.contains_any("EMAC_PACKAGEMANAGER", "deb ipk rpm", "${PACKAGE_ARCHS}", "", d)}"
PACKAGE_FEED_ARCHS = "${@remove_duplicate_values(d, "PACKAGE_ARCHS", "ALL_MULTILIB_PACKAGE_ARCHS")}"
