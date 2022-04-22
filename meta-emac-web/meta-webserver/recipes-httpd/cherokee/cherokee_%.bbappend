FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " harden-web-servers"
RDEPENDS:append = " harden-web-servers"
