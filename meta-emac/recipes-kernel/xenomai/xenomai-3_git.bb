SUMMARY = "Xenomai is a real-time development framework cooperating with the Linux \
	    kernel, in order to provide a pervasive, interface-agnostic, hard \
	    real-time support to user-space applications, seamlessly integrated \
	    into the GNU/Linux environment."

HOMEPAGE = "http://www.xenomai.org"
SECTION = "tools/realtime"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r4"

SRC_URI = "git://git.xenomai.org/xenomai-3.git"	    

# V3.0
SRCREV = "d0d67d97d840381b3ba5284cf6b843a7523bfe53"

inherit autotools

INSANE_SKIP_${PN}-dev += " libdir "
INSANE_SKIP_${PN}-dbg += " libdir "
INSANE_SKIP_${PN} += " libdir "

XENOMAI_SRC_PATH = "/usr/src/xenomai"

TARGET_CC_ARCH += "${LDFLAGS}"

#prefix_x = "${prefix}"

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

#S = "${TMPDIR}/work-shared/xenomai-${PV}/${PV}"
#B = "${WORKDIR}/xenomai-${PV}/build.${HOST_SYS}.${TARGET_SYS}"

S = "${WORKDIR}/git"

# SS means Shared Stamps directory
#SS = "${TMPDIR}/stamps/work-shared/xenomai-${PV}-${PR}"
#do_fetch[stamp-base] = "${SS}"
#do_unpack[stamp-base] = "${SS}"
#do_patch[stamp-base] = "${SS}"
#SSCLEAN = "${TMPDIR}/stamps/work-shared/xenomai-git*-*"
#do_fetch[stamp-base-clean] = "${SSCLEAN}"
#do_unpack[stamp-base-clean] = "${SSCLEAN}"
#do_unpack[umask] = "022"
#do_patch[stamp-base-clean] = "${SSCLEAN}"

# SW means Shared Work directory
#SW = "${TMPDIR}/work-shared/xenomai-${PV}"
#SSTATE_SWSPEC = "sstate:gcc::${PV}:${PR}::${SSTATE_VERSION}:"
#WORKDIR_task-unpack = "${SW}"
#WORKDIR_task-patch = "${SW}"

CFLAGS_arm := "-march=armv5e"
CFLAGS_x86 := "-m32"
EXTRA_OECONF_x86 = "--enable-smp"

do_configure () {
	cd ${S}

	# install xenomai source first to the temp folder - original source code of xenomai
#	xenomaitmpdir=${WORKDIR}/xensrc
#	if [ ! -e $xenomaitmpdir ] ; then
#		install -d $xenomaitmpdir
#		cp -fR * $xenomaitmpdir
#	fi

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

	# install sources of xenomai from temp folder created at configure stage#
#	xenomaidir=${D}${XENOMAI_SRC_PATH}
#	install -d $xenomaidir
#	cd ${WORKDIR}/xensrc
#	cp -fR * $xenomaidir
}

#do_package_qa[noexec] = "1"

sysroot_stage_all_append() {
        sysroot_stage_dir ${D}${XENOMAI_SRC_PATH} ${SYSROOT_DESTDIR}${XENOMAI_SRC_PATH}
}
