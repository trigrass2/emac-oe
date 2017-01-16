DESCRIPTION = "Xenomai gpio module"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRCREV = "b2f93cdf7437f1ea614ae2fd7a24f082d4be0a68"

SRC_URI = "git://git.emacinc.com/xenomai/rtdm-gpio-driver.git;protocol=http"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(VDX-632x-xenomai)"
