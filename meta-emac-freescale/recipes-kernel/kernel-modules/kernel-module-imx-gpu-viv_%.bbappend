LOCALVERSION = "-5.15.5-1.0.0"
SRCBRANCH = "upstream/lf-5.15.y"
SRCREV = "e47e5ff6895a7aa2f75dcb2e2c7257e25cf77901"
KERNEL_SRC = "git://git.emacinc.com/nxp-sources/linux-imx.git;protocol=http;branch=${SRCBRANCH}"

SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH};subpath=drivers/mxc/gpu-viv;destsuffix=git/src \
    file://Add-makefile.patch \
"
