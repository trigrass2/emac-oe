FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".emac1"

RRECOMMENDS:${PN}:append = " nano"