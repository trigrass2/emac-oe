FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
		file://tscal.sh \
	"
do_install:append () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/tscal.sh ${D}${bindir}/tscal.sh
}

FILES:tslib-calibrate += "${bindir}/tscal.sh"
