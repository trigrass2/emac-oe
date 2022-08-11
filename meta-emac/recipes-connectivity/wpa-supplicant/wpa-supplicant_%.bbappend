FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
		file://driver.wlan0 \
		file://wpa_supplicant.conf-sane \
		file://wpa-supplicant.sh \
	"

inherit update-rc.d

INITSCRIPT_NAME = "wpa-supplicant"
INITSCRIPT_PARAMS = "start 3 2 3 4 5 . stop 81 0 1 6 ."

do_install:append () {
	install -d ${D}${sysconfdir}/wpa_supplicant/
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/wpa-supplicant.sh ${D}${sysconfdir}/init.d/wpa-supplicant
	install -m 0644 ${WORKDIR}/driver.wlan0 ${D}${sysconfdir}/wpa_supplicant/driver.wlan0
	install -m 0644 ${WORKDIR}/wpa_supplicant.conf-sane ${D}${sysconfdir}/wpa_supplicant.conf
}
