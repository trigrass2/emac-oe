FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://0001-add-somimx6m-sources.patch \
    file://0001-add-somimx6ul-sources.patch \
    file://0002-add-to-makefiles.patch \
    file://somimx6ul_defconfig \
"

# Bring in our defconfigs
do_configure:prepend(){
    cp ${WORKDIR}/*_defconfig ${S}/configs/
}
