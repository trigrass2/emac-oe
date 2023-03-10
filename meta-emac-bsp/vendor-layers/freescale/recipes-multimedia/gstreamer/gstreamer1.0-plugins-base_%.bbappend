DEPENDS:append = " libdrm "

## Redirect source to EMAC mirror of upstream repository
GST1.0-PLUGINS-BASE_SRC = "git://git.emacinc.com/nxp-sources/gst-plugins-base.git;protocol=http"

GL_PLATFORM = "${@bb.utils.contains("EMAC_DISPLAY", "wayland", "wayland", "viv-fb", d)}"

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
    -Dgl_winsys=${GL_PLATFORM} \
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




do_install:append(){
    ## just force the headers to install for qtmultimedia on the freescale gst-good, what does it matter if there are two extra header files ? 
    install -d ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb
    cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstgldisplay_viv_fb.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
    cp -f ${WORKDIR}/git/gst-libs/gst/gl/viv-fb/gstglwindow_viv_fb_egl.h ${D}/usr/include/gstreamer-1.0/gst/gl/viv-fb/
}


COMPATIBLE_MACHINE = "(mx6dl|mx6q|mx6sl|mx6sx|mx7d|somimx6)"

