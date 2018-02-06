SUMMARY = "Xenomai is a real-time development framework cooperating with the Linux \
	    kernel, in order to provide a pervasive, interface-agnostic, hard \
	    real-time support to user-space applications, seamlessly integrated \
	    into the GNU/Linux environment."

HOMEPAGE = "http://www.xenomai.org"
SECTION = "tools/realtime"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# V3.0.6+
XBRANCH = "stable-3.0.x"
SRCREV ?= "91b3d701322014007b9d1e88db99705f38bd559e"

SRC_URI = "git://git.xenomai.org/xenomai-3.git;branch=${XBRANCH}"

DEPENDS = "fuse"

inherit autotools

INSANE_SKIP_${PN}-dev += " libdir "
INSANE_SKIP_${PN}-dbg += " libdir "
INSANE_SKIP_${PN} += " libdir "

#Make it MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "/usr/bin/* /usr/sbin/* \
		/usr/lib/* /usr/lib/xenomai/* \
		/etc/* \
		/usr/demo/* \
		/usr/share/xeno-src/*"
FILES_${PN}-doc += "/usr/share/man/* /usr/share/doc/*"
FILES_${PN}-dev += "/usr/include/*"
FILES_${PN}-staticdev += "/usr/lib/*.a"
FILES_${PN}-dbg += "/usr/bin/.debug/* /usr/sbin/.debug/* \
		 /usr/lib/.debug/* \
		 /usr/demo/.debug/* \
		"
S = "${WORKDIR}/git"

CFLAGS_x86 := "-m32"
EXTRA_OECONF_x86 = "--enable-smp"
LDFLAGS = "`pkg-config fuse --cflags --libs`"

do_configure () {
	cd ${S}

	${S}/scripts/bootstrap
        ${S}/configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --with-core=cobalt --enable-pshared ${EXTRA_OECONF} --prefix=/usr --exec_prefix=/usr --includedir=/usr/include/xenomai --enable-registry
}

do_install () {
	cd ${S}
	make DESTDIR=${D} install

	mkdir -p ${D}/usr/share/xeno-src
	cd ${S}/demo
	find . -name *.c | cpio -pdm ${D}/usr/share/xeno-src
	find . -name *.h | cpio -pdm ${D}/usr/share/xeno-src
	find . -name "Makefile.*" | cpio -pdm ${D}/usr/share/xeno-src
	
	# remove /dev entry - it will be created later in image
	rm -fR ${D}/dev
	
	mv ${D}/usr/etc ${D}/etc
}
