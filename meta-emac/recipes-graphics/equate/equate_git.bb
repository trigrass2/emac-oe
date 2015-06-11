DESCRIPTION = "Enlightenment Calculator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=344895f253c32f38e182dcaf30fe8a35"
DEPENDS = "evas ecore edje elementary"

SRCREV = "0533a7c213eca7bb4ddb5d161d429016490a9fb0"

inherit e gettext

SRC_URI = "git://git.enlightenment.org/apps/equate.git;protocol=http"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "\
    ${PN}-themes \
"

FILES_${PN} += "\
    ${datadir}/icons/equate.png \
"

EXTRA_OECONF = "\
    --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
"
