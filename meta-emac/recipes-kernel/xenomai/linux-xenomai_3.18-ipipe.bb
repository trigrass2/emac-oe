require linux-xenomai.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=linux-3.18.y;name=linux"

LINUX_VERSION ?= "3.18.20"
LINUX_VERSION_EXTENSION = "-emac-xenomai"

# tag: v3.18.20 (linux-3.18.y) e9fd6ddcabf8695329f2462d3ece5a8442f2a8cf
SRCREV="e9fd6ddcabf8695329f2462d3ece5a8442f2a8cf"

# Mark archs/machines that this kernel supports
#DEFAULT_PREFERENCE = "1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

