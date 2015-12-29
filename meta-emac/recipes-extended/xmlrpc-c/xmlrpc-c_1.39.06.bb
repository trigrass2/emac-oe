DESCRIPTION = "XML-RPC for C/C++ is programming libraries and related tools to help you \
write an XML-RPC server or client in C or C++."
LICENSE = "GPLv2+"
DEPENDS = "curl libxml2"
PR = "r0"

LIC_FILES_CHKSUM = "file://doc/COPYING;md5=aefbf81ba0750f02176b6f86752ea951"
S = "${WORKDIR}/stable"
SRC_URI = "svn://svn.code.sf.net/p/xmlrpc-c/code;module=stable;protocol=http;rev=2766"

CACHED_CONFIGUREVARS="ac_cv_path_XML2CONFIG=0"
EXTRA_OECONF = " --disable-libwww-client"

inherit autotools-brokensep

do_configure() {
	gnu-configize
	oe_runconf
}
