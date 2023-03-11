FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base:append:som5728 = " prueth-fw prusw-fw"