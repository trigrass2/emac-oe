
# On the imx6 and 7 you want to make sure that these two things get picked up
# Checking for Vivante GPU... yes
# Checking for GStreamer i.MX common... yes


DEPENDS:append = " \
    imx-gpu-viv \
    gstreamer1.0-plugins-imx \
"

RDEPENDS:${PN} += " \
    gstreamer1.0-plugins-imx \
    imx-gpu-viv \
"

COMPATIBLE_MACHINE = "(mx6dl|mx6q|mx6sl|mx6sx|mx6ul|mx6ull|mx7d)"

