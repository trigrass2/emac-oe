# TODO 
## closed caption (DONE)
## opencv
## openh264 
## ADD libde265


DEPENDS += "gstreamer1.0-plugins-base"

inherit gobject-introspection

PACKAGECONFIG ??= " \
    ${GSTREAMER_ORC} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'bluez', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'directfb vulkan', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gl', '', d)} \
    bz2 closedcaption curl dash dtls hls rsvg sbc smoothstreaming sndfile \
    ttml uvch264 webp \
"
ARM_INSTRUCTION_SET:armv4 = "arm"
ARM_INSTRUCTION_SET:armv5 = "arm"

DEPENDS:append = " \
    cmake-native \
    bzip2 \
    bluez5 \
" 

RDEPENDS:append:${PN} = " \
    bzip2 \
    bluez5 \
"

PACKAGECONFIG:append = " \
    bz2 \
    bluez \
"

## FIXME make this check against x11 and wayland 
CXXFLAGS:append = " -DEGL_API_WAYLAND "

FILES:append:${PN}-freeverb = " ${datadir}/gstreamer-1.0/presets/GstFreeverb.prs "
FILES:append:${PN}-opencv = " ${datadir}/gst-plugins-bad/1.0/opencv* "
FILES:append:${PN}-voamrwbenc = " ${datadir}/gstreamer-1.0/presets/GstVoAmrwbEnc.prs "
# include fragment shaders
FILES:append:${PN}-opengl = " /usr/share/*.fs "

COMPATIBLE_MACHINE = "(ti33x|omap-a15|dra7xx)"

