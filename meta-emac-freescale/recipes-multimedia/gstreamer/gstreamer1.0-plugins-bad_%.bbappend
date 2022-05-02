# TODO 
## closed caption (DONE)
## opencv
## openh264 
## ADD libde265

## Redirect source to EMAC mirror of upstream repository
GST1.0-PLUGINS-BAD_SRC = "git://git.emacinc.com/nxp-sources/gst-plugins-bad.git;protocol=http"

DEPENDS += " \
    bzip2 \
    bluez5 \
    imx-codec \
" 

RDEPENDS_${PN} += " \
    bzip2 \
    bluez5 \
    imx-codec \
"

PACKAGECONFIG_append += " \
    bz2 \
    bluez \
"

## FIXME make this check against x11 and wayland 
CXXFLAGS  += " -DEGL_API_FB "


COMPATIBLE_MACHINE = "(mx6dl|mx6q|mx6sl|mx6sx|mx6ul|mx6ull|mx7d)"