DESCRIPTION = "*The* screensaver package for X11"
HOMEPAGE = "http://www.jwz.org/xscreensaver/"
SECTION = "x11-misc"
LICENSE = "CLOSED"
DEPENDS = "intltool mesa mesa-glut libxml2 libglade libxpm gdk-pixbuf libxmu libxpm "

SRC_URI = "http://www.jwz.org/xscreensaver/xscreensaver-${PV}.tar.gz \
           file://configure.patch \
           file://XScreenSaver \
           file://screensaver \
"

SRC_URI[md5sum] = "b71e3a78db1ae14291cc9ff4c5e10911"
SRC_URI[sha256sum] = "3771176876a402738e0f91dcb3654b57cfa430cf90d3413a6bad5daf1d085d52"

export INTLTOOL_PERL="/usr/bin/env perl"

inherit autotools gettext update-alternatives

EXTRA_OECONF=" --with-gtk \
               --disable-locking \
               --with-dpms-ext \
               --with-pixbuf \
               --with-jpeg \
               --with-randr-ext \
               --with-gl \
               --with-gle \
               --with-gles \
               --with-xshm-ext \
               --with-setuid-hacks \
               --disable-option-checking \
               --libdir=${STAGING_LIBDIR} \
               --includedir=${STAGING_INCDIR} \
               --prefix=${B} \
"

PACKAGES =+  " xscreensaver-demo xscreensaver-extra"

FILES_${PN} = "${bindir}/xscreensaver ${bindir}/xscreensaver-text ${bindir}/xscreensaver-command ${datadir}/applications \
	${libdir}/X11/ ${bindir}/xscreensaver-gl-helper ${sysconfdir}/xdg/autostart/screensaver"

FILES_${PN}-dbg += "${libexecdir}/xscreensaver/.debug"

FILES_xscreensaver-demo = "${bindir}/xscreensaver-demo ${datadir}/xscreensaver \
	${datadir}/pixmaps/"

FILES_xscreensaver-extra = "${bindir}/xscreensaver-getimage*"

do_configure_prepend() {
	sed -i 's:GTK_DATADIR="$GTK_DATADIR/share":GTK_DATADIR="${datadir}":' ${S}/configure.in
	
}

do_compile() {
	oe_runmake CC="${CC}" LD="${CXX}" CC_HACK="${CXX}" GNOME_DATADIR=${datadir} all
}

do_install() {
	unset KDEDIR
	oe_runmake -C ${B}/driver install_prefix=${D} install

	oe_runmake -C ${B}/hacks install_prefix=${D} install-program
	oe_runmake -C ${B}/hacks/glx install_prefix=${D} install-program

	# Install the defaults file
	install -d ${D}/${libdir}/X11/app-defaults
	install -m 0644 ${WORKDIR}/XScreenSaver ${D}/${libdir}/X11/app-defaults

	install -d ${D}${sysconfdir}/xdg/autostart
	install -m 0755 ${WORKDIR}/screensaver ${D}${sysconfdir}/xdg/autostart/screensaver
}

PACKAGES_DYNAMIC = "xscreensaver-hack-*"

python populate_packages_prepend () {
    hackdir = bb.data.expand('${libexecdir}/xscreensaver', d)
    do_split_packages(d, hackdir, '^(.*)', 'xscreensaver-hack-%s', 'XScreensaver hack %s')
    metapkg = "xscreensaver-hacks"
    bb.data.setVar('ALLOW_EMPTY_' + metapkg, "1", d)
    bb.data.setVar('FILES_' + metapkg, "", d)
    blacklist = [ 'xscreensaver-locale', 'xscreensaver-dev', 'xscreensaver-dbg', 'xscreensaver-doc', 'xscreensaver-extra' ]
    metapkg_rdepends = []
    packages = bb.data.getVar('PACKAGES', d, 1).split()
    for pkg in packages[1:]:
        if not pkg in blacklist and not pkg in metapkg_rdepends:
            metapkg_rdepends.append(pkg)
    bb.data.setVar('RDEPENDS_' + metapkg, ' '.join(metapkg_rdepends), d)
    bb.data.setVar('DESCRIPTION_' + metapkg, 'Xscreensaver hacks meta package', d)
    packages.append(metapkg)
    bb.data.setVar('PACKAGES', ' '.join(packages), d)
}
