DESCRIPTION = "Advantech Susi Utilities"
LICENSE="CLOSED"

SRC_URI = "file://susi-utils.tar.gz"

S = "${WORKDIR}/susi-utils"

INSANE_SKIP_${PN} = "already-stripped"

FILES_${PN} += "${base_libdir}/*.so"
FILES_SOLIBSDEV = ""

do_install () {
	oe_runmake install DESTDIR=${D}
}
