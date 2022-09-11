FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

## this patch should really just be inthe kernel if it is really swaped on RGBA
SRC_URI:soma5d36 += " \
        file://atmel-color-format-force.patch \
"
