DESCRIPTION = "Advantech Susi kernel module"
LICENSE="CLOSED"

inherit module

SRC_URI = "file://Makefile \
           file://susi_watchdog.h \
           file://susi_wdt_main.c \
           file://wdtmodver.h \
           file://wdt_operation.c \
          "

S = "${WORKDIR}"

do_install_append() {
	install -d ${D}/usr/lib
	install -m 0644 ${WORKDIR}/SusiCores.ko ${D}/usr/lib
}

FILES_${PN} += "/usr/lib/SusiCores.ko"

RPROVIDES_${PN} += "kernel-module-susicores${KERNEL_MODULE_PACKAGE_SUFFIX}"
