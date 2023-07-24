FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://0001-Add-som-5728m-board-files.patch \
    file://0002-Add-som-5728m-defconfig.patch \
    file://u-boot-default.txt \
"

do_configure:prepend(){
    if [ -f "${WORKDIR}/u-boot-default.txt" ]; then
        cp ${WORKDIR}/u-boot-default.txt ${S}/u-boot-default.txt
    fi
}