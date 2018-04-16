FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
        file://xserver-nodm \
"

INITSCRIPT_NAME = "xserver-nodm"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 01 0 1 6 ."

