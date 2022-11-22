FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# Legacy i586 CPU support
KBRANCH:genericx86-i586  = "v5.15/standard/base"
KMACHINE:genericx86-i586 ?= "common-pc"
SRCREV_machine:genericx86-i586 ?= "efe20512212b0e85b5f884b1bfc8fbba2b43541a"
COMPATIBLE_MACHINE:genericx86-i586 = "genericx86-i586"
LINUX_VERSION:genericx86-i586 = "5.15.59"
