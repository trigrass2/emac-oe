SRCBRANCH="MM_04.05.01_1909_L4.19.35"
SRCREV = "cde60d68ab2acee913dbfacb8aabb53d87dd3e38"
SRC_URI = "git://git.emacinc.com/nxp-sources/imx-alsa-plugins.git;protocol=http;branch=${SRCBRANCH}"
PACKAGECONFIG:remove = "swpdm"
