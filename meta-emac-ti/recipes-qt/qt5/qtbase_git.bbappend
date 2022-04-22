FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:" 

PACKAGECONFIG:remove:ti = "tests examples"
PACKAGECONFIG_DEFAULT:remove:ti = "tests"
