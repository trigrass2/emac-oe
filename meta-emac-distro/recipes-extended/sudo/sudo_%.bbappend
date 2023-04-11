do_install:append() {
    # %sudo   ALL=(ALL:ALL) ALL
    sed -i 's/^#\s*\(%sudo\s*ALL=(ALL:ALL)\s*ALL\)/\1/'  ${D}/${sysconfdir}/sudoers
}

PACKAGE_ARCH = "${MACHINE_ARCH}"