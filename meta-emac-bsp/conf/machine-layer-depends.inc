# To make 1 single extensible dynamic layer that still has dep tracking
# --------------------------------------
GENERIC_LAYERDEPENDS = " yoctobsp"

LAYERDEPENDS_emac-bsp:append:genericx86-64 = " ${GENERIC_LAYERDEPENDS}"
LAYERDEPENDS_emac-bsp:append:genericx86-i586 = " ${GENERIC_LAYERDEPENDS}"
LAYERDEPENDS_emac-bsp:append:genericx86 = " ${GENERIC_LAYERDEPENDS}"

# --------------------------------------
ATMEL_LAYERDEPENDS = " \
    atmel \
"

LAYERDEPENDS_emac-bsp:append:ipac9x25 = " ${ATMEL_LAYERDEPENDS}"

LAYERDEPENDS_emac-bsp:append:som9x25 = " ${ATMEL_LAYERDEPENDS}"

LAYERDEPENDS_emac-bsp:append:soma5d35 = " ${ATMEL_LAYERDEPENDS}"

LAYERDEPENDS_emac-bsp:append:soma5d36 = " ${ATMEL_LAYERDEPENDS}"

# ---------------------------------------
FREESCALE_LAYERDEPENDS= " \
    freescale-layer \
    freescale-3rdparty \
"

LAYERDEPENDS_emac-bsp:append:somimx6 = " ${FREESCALE_LAYERDEPENDS}"

LAYERDEPENDS_emac-bsp:append:somimx6ul = " ${FREESCALE_LAYERDEPENDS}"

# ----------------------------------------
INTEL_LAYERDEPENDS= " \
    intel \
"

#LAYERDEPENDS_emac-bsp:append:core-i7-64 = " ${INTEL_LAYERDEPENDS}"

# ----------------------------------------
TEXASINSTRUMENTS_LAYERDEPENDS = " \
    meta-ti-bsp \
"

TEXASINSTRUMENTS_LAYERRECOMMENDS = " \
    meta-arago-distro \
"

LAYERDEPENDS_emac-bsp:append:som3354 = " ${TEXASINSTRUMENTS_LAYERDEPENDS}"
LAYERRECOMMENDS_emac-bsp:append:som3354 = " ${TEXASINSTRUMENTS_LAYERRECOMMENDS}"

LAYERDEPENDS_emac-bsp:append:som5728 = " ${TEXASINSTRUMENTS_LAYERDEPENDS}"
LAYERRECOMMENDS_emac-bsp:append:som5728 = " ${TEXASINSTRUMENTS_LAYERRECOMMENDS}"

# ----------------------------------------