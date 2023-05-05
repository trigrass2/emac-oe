require at91bootstrap.inc

BSBRANCH = "emac-bootstrap-3.7.2"
SRCREV = "535ea91959b4d886a1ec59b4343a11689e849eaa"
PV = "v3.7.2+git${SRCPV}"

SRC_URI = "git://git.emacinc.com/bootloader/at91-bootstrap.git;branch=${BSBRANCH};protocol=http"
S = "${WORKDIR}/git"
