FILESEXTRAPATHS:prepend := "${THISDIR}/linux-fslc-imx/${MACHINE}:" 

KBRANCH = "5.15-1.0.x-imx-emac"
# SRCREV = "1248f5fdf27d474537f14ada7144a4622df4affc"

SRC_URI = "git://git.emacinc.com/linux-kernel/linux-fslc.git;branch=${KBRANCH};protocol=http \
           file://defconfig \
"

