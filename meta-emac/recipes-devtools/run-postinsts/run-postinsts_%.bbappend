FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
        file://init-partition \
"

do_install:append () {
    install -d ${D}${sysconfdir}/ipk-postinsts
    install -m 0755 ${WORKDIR}/init-partition ${D}${sysconfdir}/ipk-postinsts/00_init-partition
}

