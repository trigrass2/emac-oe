FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " \
        file://init-partition \
"

do_install_append () {
    install -d ${D}${sysconfdir}/ipk-postinsts
    install -m 0755 ${WORKDIR}/init-partition ${D}${sysconfdir}/ipk-postinsts/00_init-partition
}

