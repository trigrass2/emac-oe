SUMMARY = "Xenomai is a real-time development framework cooperating with the Linux \
	    kernel, in order to provide a pervasive, interface-agnostic, hard \
	    real-time support to user-space applications, seamlessly integrated \
	    into the GNU/Linux environment."

HOMEPAGE = "http://www.xenomai.org"
SECTION = "tools/realtime"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# V3.0.8
XBRANCH ?= "stable/v3.0.x"
SRCREV ?= "fbc3271096c63b21fe895c66ba20b1d10d72ff48"

SRC_URI = "git://git.xenomai.org/xenomai-3.git;branch=${XBRANCH}"

DEPENDS = "fuse"

inherit autotools pkgconfig

#Make it MACHINE specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "\
	${libdir}/cobalt.wrappers ${libdir}/modechk.wrappers \
	${libdir}/dynlist.ld \
	"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--includedir=${includedir}/xenomai --with-demodir=${bindir} --enable-registry --with-core=cobalt --enable-pshared"
CFLAGS_x86 := "-m32"
EXTRA_OECONF_append_x86 = "--enable-smp"
EXTRA_OECONF_append_somimx6-xenomai = "--enable-smp"

LDFLAGS = "`pkg-config fuse --cflags --libs`"


do_install_append () {
	rm -fR ${D}/dev
	rm -rf ${D}/${libdir}/xenomai
}
