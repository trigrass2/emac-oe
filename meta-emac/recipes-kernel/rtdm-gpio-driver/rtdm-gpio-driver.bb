DESCRIPTION = "Xenomai gpio module"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRCREV = "c2191cac256b20bef8b487f117ac16ff508c1569"

SRC_URI = "git://git.emacinc.com/xenomai/rtdm-gpio-driver.git;protocol=http"

S = "${WORKDIR}/git"
