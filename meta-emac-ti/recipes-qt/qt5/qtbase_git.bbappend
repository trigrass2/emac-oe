FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:" 

PACKAGECONFIG_remove_ti = "tests examples"
PACKAGECONFIG_DEFAULT_remove_ti = "tests"
