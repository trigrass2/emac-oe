DESCRIPTION = "XML-RPC for C/C++ is programming libraries and related tools to help you \
write an XML-RPC server or client in C or C++."
LICENSE = "GPLv2+"
DEPENDS = "curl libxml2"
RDEPENDS_${PN} = "curl perl"

PR = "r0"

LIC_FILES_CHKSUM = "file://doc/COPYING;md5=aefbf81ba0750f02176b6f86752ea951"

B = "${S}"

inherit autotools-brokensep

SRC_URI = " \
            ${SOURCEFORGE_MIRROR}/project/${BPN}/Xmlrpc-c%20Super%20Stable/${PV}/${BPN}-${PV}.tgz \
	    file://buildtool_configure.patch \
"
SRC_URI[md5sum] = "1e01d4a462198b6c0a4f44b66cbf7a93"
SRC_URI[sha256sum] = "d830f3264a832dfe09f629cc64036acfd08121692526d0fabe090f7ff881ce08"

EXTRA_OECONF += "--disable-libwww-client"

do_configure () {
	oe_runconf
}
