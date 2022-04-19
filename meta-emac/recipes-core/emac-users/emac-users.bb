
DESCRIPTION = "User creation for EMAC OE"
LICENSE = "GPLv2"


inherit extrausers

ROOTPASSWD = "ga4u8j0W5umY."
PASSWD = "fb7SZfwDJvKFo"
EXTRA_USERS_PARAMS = " \
            usermod -p '${ROOTPASSWD}' root; \
            usermod -d /root root; \
            useradd emac; \
            usermod -p '${PASSWD}' emac; \
            usermod -aG sudo emac; \
            usermod -aG dialout emac; \
            usermod -d /home/emac emac;\
            "

do_install_append () {
    install -d ${D}${sysconfdir}/sudoers.d
    echo "%sudo ALL=(ALL) ALL" > ${D}${sysconfdir}/sudoers.d/0001_sudo_grp
}
