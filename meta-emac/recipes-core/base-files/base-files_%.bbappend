FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
        file://profile \
        file://shells \
        file://fstab \
        file://share/dot.bashrc \
        file://share/dot.profile \
    "
