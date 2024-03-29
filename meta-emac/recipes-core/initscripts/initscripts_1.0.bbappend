FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

SRC_URI = "file://functions \
           file://halt \
           file://umountfs \
           file://devpts.sh \
           file://devpts \
           file://hostname.sh \
           file://mountall.sh \
           file://bootmisc.sh \
           file://mountnfs.sh \
           file://reboot \
           file://checkfs.sh \
           file://single \
           file://sendsigs \
           file://rmnologin.sh \
           file://checkroot.sh \
           file://umountnfs.sh \
           file://sysfs.sh \
           file://populate-volatile.sh \
           file://volatiles \
           file://GPLv2.patch \
"

SRC_URI_append_arm = " file://alignment.sh"

do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${sysconfdir}/rc0.d
	install -d ${D}${sysconfdir}/rc1.d
	install -d ${D}${sysconfdir}/rc2.d
	install -d ${D}${sysconfdir}/rc3.d
	install -d ${D}${sysconfdir}/rc4.d
	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}${sysconfdir}/rc6.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/default/volatiles

	install -m 0644    ${WORKDIR}/functions		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/bootmisc.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/checkroot.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/halt		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/hostname.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/mountall.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/mountnfs.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/reboot		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rmnologin.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/sendsigs		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/single		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/umountnfs.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/devpts.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/devpts		${D}${sysconfdir}/default
	install -m 0755    ${WORKDIR}/sysfs.sh		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/populate-volatile.sh ${D}${sysconfdir}/init.d
	install -m 0644    ${WORKDIR}/volatiles		${D}${sysconfdir}/default/volatiles/00_core

	if [ "${TARGET_ARCH}" = "arm" ]; then
		install -m 0755 ${WORKDIR}/alignment.sh	${D}${sysconfdir}/init.d
	fi
#
# Install device dependent scripts
#
	install -m 0755 ${WORKDIR}/umountfs	${D}${sysconfdir}/init.d/umountfs
#
# Create runlevel links
#
	update-rc.d -r ${D} rmnologin.sh start 99 2 3 4 5 .
	update-rc.d -r ${D} sendsigs start 20 0 6 .
	update-rc.d -r ${D} umountnfs.sh start 31 0 1 6 .
	update-rc.d -r ${D} umountfs start 40 0 6 .
	update-rc.d -r ${D} reboot start 90 6 .
	update-rc.d -r ${D} halt start 90 0 .
	update-rc.d -r ${D} checkroot.sh start 06 S .
	update-rc.d -r ${D} mountall.sh start 03 S .
	update-rc.d -r ${D} hostname.sh start 39 S .
	update-rc.d -r ${D} mountnfs.sh start 15 2 3 4 5 .
	update-rc.d -r ${D} bootmisc.sh start 55 S .
	update-rc.d -r ${D} sysfs.sh start 02 S .
	update-rc.d -r ${D} populate-volatile.sh start 37 S .
	update-rc.d -r ${D} devpts.sh start 38 S .
	if [ "${TARGET_ARCH}" = "arm" ]; then
	        update-rc.d -r ${D} alignment.sh start 06 S .
	fi
	# We wish to have /var/log ready at this stage so execute this after
	# populate-volatile.sh
}
