FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
		file://10-evdev.conf \
	"

do_install_append () {	
	install -d ${D}${datadir}/X11/xorg.conf.d
	install -m 0644 ${WORKDIR}/10-evdev.conf ${D}${datadir}/X11/xorg.conf.d/10-evdev.conf
}
