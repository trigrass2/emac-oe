DESCRIPTION = "Xenomai gpio module"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRCREV = "866e3ccbd6d3c01f38ba4673ea2103ed74bd6a10"

SRC_URI = "git://git.emacinc.com/xenomai/rtdm-gpio-driver.git;protocol=http"

S = "${WORKDIR}/git"

#COMPATIBLE_MACHINE = "(VDX-632x-xenomai)"
