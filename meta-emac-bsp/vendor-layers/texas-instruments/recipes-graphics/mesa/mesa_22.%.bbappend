# https://gitlab.freedesktop.org/StaticRocket/mesa/-/commit/44b82a7b6fa8a86243911b1b0d6a07b0fd8ecfba
# This commit made it to where the builder would not find the pvr_dri_support.so which subsequently caused linkage error
# This is most likely a mistake since dri is only built with x11 according to mesa's PACKAGECONFIG
# meta-arago-distro removes x11 from its distro which may be why this was not caught
# TODO: revisit on updates to meta-ti-bsp or gitlab.freedesktop.org/StaticRocket/mesa

PACKAGECONFIG[sgx] = "-Dgallium-sgx-alias=${PVR_DISPLAY_CONTROLLER_ALIAS},,ti-sgx-ddk-um,ti-sgx-ddk-um"
SRCREV = "782d20add4ac718a9a23efda7ef3e20b1aa94335"