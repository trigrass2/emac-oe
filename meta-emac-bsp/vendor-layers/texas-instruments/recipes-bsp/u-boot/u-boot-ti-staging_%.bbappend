FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://0001-som-5728m-board-addition.patch \
    file://0002-som-5728-changes.patch \
    file://u-boot-default.txt \
"

do_configure:prepend(){
    if [ -f "${WORKDIR}/u-boot-default.txt" ]; then
        cp ${WORKDIR}/u-boot-default.txt ${S}/u-boot-default.txt
    fi
}