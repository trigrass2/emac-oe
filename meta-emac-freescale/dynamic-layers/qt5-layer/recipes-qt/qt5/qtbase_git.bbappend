FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:" 

PACKAGECONFIG:remove:mx6 = "tests examples"
PACKAGECONFIG_DEFAULT:remove:mx6 = "tests"
