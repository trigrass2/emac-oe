DEPENDS_ti33x += " \
    wayland \
    wayland-native \
    wayland \
    wayland-protocols \
    libdrm \
    ti-sgx-ddk-um \
    gstreamer1.0 \
    iso-codes \
    util-linux \
    zlib \
    cmake-native \
    glib-2.0-native \
"

DEPENDS_dra7xx += " \
    wayland \
    wayland-native \
    wayland \
    wayland-protocols \
    libdrm \
    ti-gc320-libs \
    ti-sgx-ddk-um \
    gstreamer1.0 \
    iso-codes \
    util-linux \
    zlib \
    cmake-native \
    glib-2.0-native \
"

PACKAGECONFIG += " \
  ogg pango png theora vorbis alsa gles2 egl wayland gbm \
"

## HACKY but it works.
EXTRA_OEMESON = " \
    -Dexamples=disabled \
    -Ddbghelp=disabled \
    -Dgtk_doc=disabled \
    -Dintrospection=disabled \
    -Dexamples=disabled \
    -Dnls=enabled \
    -Dgl_api=gles2 \
    -Dgl_platform=egl \
    -Dgl_winsys=wayland \
    -Dalsa=enabled \
    -Dcdparanoia=disabled \
    -Dgl-jpeg=enabled \
    -Dogg=enabled \
    -Dopus=disabled \
    -Dorc=disabled \
    -Dpango=enabled \
    -Dgl-png=enabled \
    -Dtheora=enabled \
    -Dtremor=disabled \
    -Dlibvisual=disabled \
    -Dvorbis=enabled \
    -Dx11=disabled  \
    -Dxvideo=disabled  \
    -Dxshm=disabled \
" 

# do_install_omap-a15_append(){
#      install -d ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb
#      cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstgldisplay_viv_fb.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
#      cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstglwindow_viv_fb_egl.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
# }


COMPATIBLE_MACHINE = "(ti33x|omap-a15|dra7xx)"

