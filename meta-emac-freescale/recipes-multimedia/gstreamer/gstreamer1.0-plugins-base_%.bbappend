DEPENDS:append = " libdrm "


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
    -Dgl_winsys=viv-fb \
    -Dextra_imx_incdir=${WORKDIR}/recipe-sysroot/usr/include/imx \
    -Dalsa=disabled  \
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




do_install_append(){
    install -d ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb
    cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstgldisplay_viv_fb.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
    cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstglwindow_viv_fb_egl.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
}


COMPATIBLE_MACHINE = "(mx6dl|mx6q|mx6sl|mx6sx|mx6ul|mx6ull|mx7d)"

