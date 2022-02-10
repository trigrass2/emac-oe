FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:" 

PACKAGECONFIG_remove_mx6 = "tests examples"
PACKAGECONFIG_DEFAULT_remove_mx6 = "tests"
