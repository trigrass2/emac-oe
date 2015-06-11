FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
		file://tscal.sh \
	"
do_install_append () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/tscal.sh ${D}${bindir}/tscal.sh
}

FILES_tslib-calibrate += "${bindir}/tscal.sh"
