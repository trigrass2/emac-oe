#
# Copyright (C) 2022  EMAC Inc, All rights reserved
#

DESCRIPTION = "EMAC Tiny Package Groups"
LICENSE = "GPLv2"

PV = "${MAJOR_DISTRO_VERSION}.${MINOR_DISTRO_VERSION}.${PATCH_DISTRO_VERSION}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = " \
    ${PN} \
    ${PN}-util \
"

PACKAGES = " \
    ${PN} \
    ${PN}-util \
"

SUMMARY:${PN} = "EMAC Tiny Core Utilities"
RRECOMMENDS:${PN} = " ${PN}-util "

SUMMARY:${PN}-util = "EMAC Tiny Core Utilities"
RRECOMMENDS:${PN}-util = " ifplugd "
