DESCRIPTION = "Advantech Susi Utilities"
LICENSE="CLOSED"

SRC_URI = "file://susi-utils.tar.gz"

S = "${WORKDIR}/susi-utils"

INSANE_SKIP_${PN} = "already-stripped ldflags"

FILES_${PN} += "${bindir}/* ${libdir}/lib*.so*"
FILES_${PN}-dev = "${includedir}/*.h  ${includedir}/*.H"

do_install() {
	oe_runmake install DESTDIR=${D} BINDIR=${bindir} LIBDIR=${libdir} INCLUDEDIR=${includedir}
	cd ${D}${libdir}
	ln -sf libEApi.so libEApi.so.1
	ln -sf libEApi.so libEApi.so.1.0.3
}
