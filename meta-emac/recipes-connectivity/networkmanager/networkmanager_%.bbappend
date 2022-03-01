FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://NetworkManager.conf \
    file://10-globally-managed-devices.conf \
"

DEPENDS += " \
    nss \
    ${@bb.utils.contains('EMAC_INITMANAGER', 'systemd', 'systemd', '', d )} \
"

PACKAGECONFIG += " \
    bluez5 \
    modemmanager \
    ppp \
    dhclient \
    nss \
    dnsmasq \
    wifi \
    ifupdown \
    ${@bb.utils.contains('EMAC_INITMANAGER', 'systemd', 'systemd', '', d )} \
"

do_install_append() {
    install -m 0644 ${WORKDIR}/NetworkManager.conf ${D}/${sysconfdir}/NetworkManager/
    install -m 0644 ${WORKDIR}/10-globally-managed-devices.conf ${D}/${sysconfdir}/NetworkManager/conf.d/
}

