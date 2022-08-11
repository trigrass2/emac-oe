do_compile:append() {
	oe_runmake apmsleep
}

do_install:append() { 
	install -m 0755 ${S}/.libs/apmsleep ${D}${bindir}/apmsleep
}
