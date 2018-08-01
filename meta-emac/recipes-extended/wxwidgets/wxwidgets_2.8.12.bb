DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"

LICENSE = "WXwindows"
LIC_FILES_CHKSUM = "file://docs/licence.txt;md5=18346072db6eb834b6edbd2cdc4f109b"

DEPENDS = "webkitgtk gtk+ jpeg tiff libpng zlib expat libxinerama libglu"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxWidgets-${PV}.tar.bz2"
SRC_URI[md5sum] = "4103e37e277abeb8aee607b990c215c4"
SRC_URI[sha256sum] = "3b0ac1d2d017683851841501c8e1b744b97242d684a1668ded61809b0504f707"

S = "${WORKDIR}/wxWidgets-${PV}"

inherit autotools-brokensep pkgconfig binconfig

EXTRA_AUTORECONF = " -I ${S}/build/aclocal"
EXTRA_OECONF = "  --without-sdl \
                 --disable-gpe \
                 --disable-visibility \
                 --disable-rpath \
                 --enable-unicode \
               "

CXXFLAGS := "${@oe.utils.str_filter_out('-fvisibility-inlines-hidden', '${CXXFLAGS}', d)}"
CXXFLAGS += "-std=gnu++11"

# Broken autotools :/
do_configure() {
	oe_runconf
}

# wx-config contains entries like this:
# this_prefix=`check_dirname "/build/v2013.06/build/tmp-angstrom_v2013_06-eglibc/work/cortexa8hf-vfp-neon-angstrom-linux-gnueabi/wxwidgets/2.9.5-r0/wxWidgets-2.9.5"`
do_install_prepend() {
	sed -i -e s:${S}:${STAGING_DIR_HOST}${prefix}:g ${S}/wx-config
	sed -i -e /^this_prefix/,+3d ${S}/wx-config
}

# wx-config doesn't handle the suffixed libwx_media, xrc, etc, make a compat symlink
do_install_append() {
	for lib in adv aui core html qa richtext xrc ; do
		ln -sf libwx_gtk2u_$lib-2.8.so.0.8.0 ${D}${libdir}/libwx_gtk2u_$lib-2.8.so
	done
	sed -i -e s:^includedir=.*$:"includedir=\$\{prefix\}/usr/include":g ${D}${libdir}/wx/config/arm-emac-linux-gnueabi-gtk2-unicode-release-2.8
	sed -i -e s:^libdir=.*$:libdir=\$\{prefix\}/usr/lib:g ${D}${libdir}/wx/config/arm-emac-linux-gnueabi-gtk2-unicode-release-2.8
	ln -sf ../lib/wx/config/arm-emac-linux-gnueabi-gtk2-unicode-release-2.8 ${D}${bindir}/wx-config
}


FILES_${PN} += "${bindir} ${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"
