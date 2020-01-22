FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

INITSCRIPT_PARAMS = "start 99 5 2 . stop 01 0 1 6 ."
