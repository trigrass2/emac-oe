require at91bootstrap.inc

BSBRANCH = "emac-bootstrap-3.7.2"
SRCREV = "c763406164d697d85870d0034aade13e6a86c5f8"
PV = "v3.7.2+git${SRCPV}"

SRC_URI = "git://gitlab.emacinc.com/bootloader/at91-bootstrap.git;branch=${BSBRANCH};protocol=http"
S = "${WORKDIR}/git"
