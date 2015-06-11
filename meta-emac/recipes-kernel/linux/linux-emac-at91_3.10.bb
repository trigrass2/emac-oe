require recipes-kernel/linux/linux-yocto.inc

KBRANCH = "linux-3.10-at91"
SRCREV_machine = "f63a8c363aa2180c2fbcce9db75a00ee6fd3f220"

SRC_URI = "git://gitlab.emacinc.com/linux-kernel/linux-at91.git;bareclone=1;branch=${KBRANCH};name=machine;protocol=http"

LINUX_VERSION = "3.10.0"
LINUX_VERSION_EXTENSION ?= "-emac-standard"

PV = "${LINUX_VERSION}+git${SRCREV_machine}"
