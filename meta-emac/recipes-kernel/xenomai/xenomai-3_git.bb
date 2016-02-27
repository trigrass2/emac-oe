SUMMARY = "Xenomai is a real-time development framework cooperating with the Linux \
	    kernel, in order to provide a pervasive, interface-agnostic, hard \
	    real-time support to user-space applications, seamlessly integrated \
	    into the GNU/Linux environment."

HOMEPAGE = "http://www.xenomai.org"
SECTION = "tools/realtime"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# V3.0.1
XBRANCH = "stable-3.0.x"
SRCREV = "ce604a92b249e84d888f58327b34239330b063e5"

SRC_URI = "git://git.xenomai.org/xenomai-3.git;branch=${XBRANCH}"

inherit autotools

INSANE_SKIP_${PN}-dev += " libdir "
INSANE_SKIP_${PN}-dbg += " libdir "
INSANE_SKIP_${PN} += " libdir "

#Make it MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "/usr/bin/* /usr/sbin/* \
		/usr/lib/* /usr/lib/xenomai/* \
		/etc/* \
		/usr/demo/* \"
FILES_${PN}-doc += "/usr/xenomai/share/*"
FILES_${PN}-dev += "/usr/xenomai/include/*"
FILES_${PN}-staticdev += "/usr/lib/*.a"
FILES_${PN}-dbg += "/usr/bin/.debug/* /usr/sbin/.debug/* \
		 /usr/lib/.debug/* \
		 /usr/demo/.debug/* \
		"

S = "${WORKDIR}/git"

CFLAGS_arm ?= "-march=armv5e"
CFLAGS_x86 := "-m32"
EXTRA_OECONF_x86 = "--enable-smp"

do_configure () {
	cd ${S}

	${S}/scripts/bootstrap
        ${S}/configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --with-core=cobalt --enable-pshared ${EXTRA_OECONF} CFLAGS=${CFLAGS} LDFLAGS=${CFLAGS} --exec_prefix=/usr --includedir=/usr/include/xenomai
}

do_compile () {
	cd ${S}
	make
}

do_install () {
	cd ${S}
	make DESTDIR=${D} install
	
	# remove /dev entry - it will be created later in image
	rm -fR ${D}/dev
	
	mv ${D}/usr/xenomai/etc/ ${D}

}
