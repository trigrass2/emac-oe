do_compile:append() {
	oe_runmake "LIBTOOL=${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool" apmsleep
}

do_install:append() { 
	install -m 0755 ${S}/.libs/apmsleep ${D}${bindir}/apmsleep
}
