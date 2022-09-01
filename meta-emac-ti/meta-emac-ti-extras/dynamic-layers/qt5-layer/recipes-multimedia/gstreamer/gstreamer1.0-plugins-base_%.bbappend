DEPENDS:append = " \
    util-linux \
    zlib \
    cmake-native \
    glib-2.0-native \
    wayland-native \
    wayland \
    wayland-protocols \
    libdrm \
    iso-codes \
    gstreamer1.0 \
    ti-sgx-ddk-um \
"

DEPENDS:dra7xx:append = " \
    ti-gc320-libs \
"

PACKAGECONFIG:append = " \
  ogg pango png theora vorbis alsa gles2 egl wayland gbm \
"

EXTRA_OEMESON = " \
    -Ddoc=disabled \
    -Dexamples=disabled \
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

do_install:dra7xx:append(){
     install -d ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb
     cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstgldisplay_viv_fb.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
     cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstglwindow_viv_fb_egl.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
}

COMPATIBLE_MACHINE = "(omap-a15|dra7xx|ti33x|qemuarm|qemux86-64)"
