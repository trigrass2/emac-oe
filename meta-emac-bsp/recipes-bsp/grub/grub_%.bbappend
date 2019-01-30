FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://40_custom"

GRUB_DEVICE ?= "/dev/sda1"
GRUB_CMDLINE_LINUX ?= ""
GRUB_CMDLINE_LINUX_DEFAULT ?= "quiet splash ro rootfstype=ext4"
GRUB_GFXMODE ?= ""
GRUB_SERIAL_COMMAND ?= "ttyS0,115200"

do_install_append () {
	install -m 0755 ${WORKDIR}/40_custom ${D}${sysconfdir}/grub.d/
	echo "GRUB_DEVICE=\"${GRUB_DEVICE}\"" >> ${D}${sysconfdir}/default/grub
	echo "GRUB_CMDLINE_LINUX=\"${GRUB_CMDLINE_LINUX}\"" >> ${D}${sysconfdir}/default/grub
	echo "GRUB_CMDLINE_LINUX_DEFAULT=\"${GRUB_CMDLINE_LINUX_DEFAULT}\"" >> ${D}${sysconfdir}/default/grub
	echo "GRUB_GFXMODE=${GRUB_GFXMODE}" >> ${D}${sysconfdir}/default/grub
	echo "GRUB_SERIAL_COMMAND=\"${GRUB_SERIAL_COMMAND}\"" >> ${D}${sysconfdir}/default/grub		
	[ ! -z ${GRUB_GFXMODE} ] && VGA="vga=${GRUB_GFXMODE}"
	BOOTSTRING="linux16 /boot/bzImage root=${GRUB_DEVICE} console=${GRUB_SERIAL_COMMAND} $VGA ${GRUB_CMDLINE_LINUX_DEFAULT} ${GRUB_CMDLINE_LINUX}"
	sed -i -e "0,\|linux16.*|s||${BOOTSTRING}|" ${D}/boot/grub/grub.cfg
}
