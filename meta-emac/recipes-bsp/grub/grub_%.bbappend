FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

GRUB_DEVICE ?= "/dev/sda1"
GRUB_CMDLINE_LINUX ?= ""
GRUB_CMDLINE_LINUX_DEFAULT ?= "quiet splash ro rootfstype=ext4"
GRUB_GFXMODE ?= ""
GRUB_SERIAL_COMMAND ?= "ttyS0,115200"

SRC_URI:append = " \
	file://grub.cfg \
	file://10_linux \
	file://grub-default \
	file://0002-remove-text.patch \
        file://40_custom \
"
do_install:append () {
	install -d ${D}${sysconfdir}/default/
	install -d ${D}/boot/grub
	install -m 0755 ${WORKDIR}/10_linux ${D}${sysconfdir}/grub.d/
	install -m 0644 ${WORKDIR}/grub-default ${D}${sysconfdir}/default/grub
	install -m 0644 ${WORKDIR}/grub.cfg ${D}/boot/grub/

    install -m 0755 ${WORKDIR}/40_custom ${D}${sysconfdir}/grub.d/
    echo "GRUB_DEVICE=\"${GRUB_DEVICE}\"" >> ${D}${sysconfdir}/default/grub
    echo "GRUB_CMDLINE_LINUX=\"${GRUB_CMDLINE_LINUX}\"" >> ${D}${sysconfdir}/default/grub
    echo "GRUB_CMDLINE_LINUX_DEFAULT=\"${GRUB_CMDLINE_LINUX_DEFAULT}\"" >> ${D}${sysconfdir}/default/grub
    echo "GRUB_GFXMODE=${GRUB_GFXMODE}" >> ${D}${sysconfdir}/default/grub
    echo "GRUB_SERIAL_COMMAND=\"${GRUB_SERIAL_COMMAND}\"" >> ${D}${sysconfdir}/default/grub		
    [ ! -z ${GRUB_GFXMODE} ] && VGA="vga=${GRUB_GFXMODE}"
    [ ! -z ${GRUB_SERIAL_COMMAND} ] && CONSOLE="console=${GRUB_SERIAL_COMMAND}"
    BOOTSTRING="linux16 /boot/bzImage root=${GRUB_DEVICE} $CONSOLE $VGA ${GRUB_CMDLINE_LINUX_DEFAULT} ${GRUB_CMDLINE_LINUX}"
    sed -i -e "0,\|linux16.*|s||${BOOTSTRING}|" ${D}/boot/grub/grub.cfg	

}

FILES:${PN} += "/boot/grub ${sysconfdir}/default"
PACKAGE_ARCH = "${MACHINE_ARCH}"
