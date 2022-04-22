RDEPENDS:${PN}:append_x86 = " libpci"

PACKAGECONFIG:x86-64:append = " \
    cups \
    kiosk-mode \
    proprietary-codecs \
    use-vaapi \
"

