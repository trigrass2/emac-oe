FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI:append:ipac9x25 += " \
                file://0001-Fixed-uboot-spi-flash-detect.patch \
        "
