DESCRIPTION = "XML-RPC for C/C++ is programming libraries and related tools to help you \
write an XML-RPC server or client in C or C++."
LICENSE = "GPLv2+"
DEPENDS = "curl"
PR = "r0"

LIC_FILES_CHKSUM = "file://doc/COPYING;md5=aefbf81ba0750f02176b6f86752ea951"

B = "${S}"

inherit autotools-brokensep

SRC_URI = " \
            ${SOURCEFORGE_MIRROR}/project/${BPN}/Xmlrpc-c%20Super%20Stable/${PV}/${BPN}-${PV}.tgz \
            file://buildtool_configure.patch \
"
SRC_URI[md5sum] = "cb8d3df3d40be16dd4cadc3d650d1964"
SRC_URI[sha256sum] = "b79aaa657084e26e7b732502f07b3af68375e37aeb1d1cd577ea3a413d7e1af3"

do_configure () {
	${S}/configure --prefix=${prefix} --build=${BUILD_SYS} --host=${TARGET_SYS} --disable-libwww-client
}
