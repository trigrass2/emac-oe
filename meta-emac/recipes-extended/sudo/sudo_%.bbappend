do_install_append () {
    install -d ${D}${sysconfdir}/sudoers.d
    echo "%sudo ALL=(ALL) ALL" > ${D}${sysconfdir}/sudoers.d/0001_sudo_grp
}
