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
