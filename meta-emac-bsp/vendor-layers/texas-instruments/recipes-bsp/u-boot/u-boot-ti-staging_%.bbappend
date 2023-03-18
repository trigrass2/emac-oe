FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://board-add.patch \
    file://board-src-package.tar;unpack=false \
    file://u-boot-default.txt \
"

do_configure:prepend(){
    tar xf ${WORKDIR}/board-src-package.tar -C ${S}/

    if [ -f "${WORKDIR}/u-boot-default.txt" ]; then
        cp ${WORKDIR}/u-boot-default.txt ${S}/u-boot-default.txt
    fi
}