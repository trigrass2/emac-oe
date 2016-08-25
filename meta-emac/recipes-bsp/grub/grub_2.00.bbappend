FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
	file://grub.cfg \
	file://10_linux \
	file://grub-default \
	file://0002-remove-text.patch \
"
do_install_append () {
	install -d ${D}${sysconfdir}/default/
	install -d ${D}/boot/grub
	install -m 0755 ${WORKDIR}/10_linux ${D}${sysconfdir}/grub.d/
	install -m 0644 ${WORKDIR}/grub-default ${D}${sysconfdir}/default/grub
	install -m 0644 ${WORKDIR}/grub.cfg ${D}/boot/grub/
}

FILES_${PN} += "/boot/grub ${sysconfdir}/default"
PACKAGE_ARCH = "${MACHINE_ARCH}"
