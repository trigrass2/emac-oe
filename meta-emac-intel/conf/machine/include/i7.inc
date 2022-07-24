#@TYPE: Machine
#@NAME: intel-corei7-64

#@DESCRIPTION: Machine configuration for 64 bit Intel Core i7 CPU (and later) with MMX, SSE, SSE2, SSE3, and SSSE3 instruction set support. Supports a moderately wide range of drivers that should boot and be usable on "typical" hardware.

require conf/machine/include/meta-intel.inc
require conf/machine/include/intel-corei7-64-common.inc
require conf/machine/include/intel-common-pkgarch.inc

MACHINE_FEATURES:append  = " pcbios efi wifi 3g nfc intel-ucode "

MACHINE_HWCODECS ?= "${@bb.utils.contains('TUNE_FEATURES', 'mx32', '', 'intel-media-driver intel-mediasdk', d)} intel-vaapi-driver gstreamer1.0-vaapi"

# Enable optional dpdk:
COMPATIBLE_MACHINE:pn-dpdk = "intel-corei7-64"

# Enable optional QAT items:
COMPATIBLE_MACHINE:pn-qat16 = "intel-corei7-64"
COMPATIBLE_MACHINE:pn-qat17 = "intel-corei7-64"
COMPATIBLE_MACHINE:pn-zlib-qat = "intel-corei7-64"

XSERVER ?= "${XSERVER_X86_BASE} \
            ${XSERVER_X86_EXT} \
            ${XSERVER_X86_FBDEV} \
            ${XSERVER_X86_I915} \
            ${XSERVER_X86_I965} \
            ${XSERVER_X86_MODESETTING} \
            ${XSERVER_X86_VESA} \
            ${XSERVER_X86_ASPEED_AST} \
           "

SYSLINUX_OPTS = "serial 0 115200"
SERIAL_CONSOLES = "115200;ttyS0 115200;ttyS1 115200;ttyS2"
APPEND += "rootwait console=ttyS0,115200 console=tty0" 