DESCRIPTION = "Advantech Susi Utilities"
LICENSE="CLOSED"

SRC_URI = "file://susi-utils.tar.gz"

S = "${WORKDIR}/susi-utils"

INSANE_SKIP_${PN} = "already-stripped"

FILES_${PN} += "${base_libdir}/*.so"
FILES_SOLIBSDEV = ""
FILES_${PN}-dev = "${includedir}/define.h  ${includedir}/REL_EC_API.h ${includedir}/REL_DEBUG.H"

do_install () {
	oe_runmake install DESTDIR=${D}
	install -d ${D}${includedir}
	install -m 0666  ${S}/*.h ${D}${includedir}
	install -m 0666  ${S}/*.H ${D}${includedir}
}
