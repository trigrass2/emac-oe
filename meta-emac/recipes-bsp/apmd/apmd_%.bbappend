do_compile_append() {
	oe_runmake "LIBTOOL=${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool" apmsleep
}

do_install_append() { 
	install -m 0755 ${S}/.libs/apmsleep ${D}${bindir}/apmsleep
}
