### X11
PREFERRED_PROVIDER_virtual/xserver ?= "xserver-xorg"

XSERVER ?= "\
    ${XSERVER_X86_BASE} \
    ${XSERVER_X86_EXT} \
    ${XSERVER_X86_I915} \
    ${XSERVER_X86_I965} \
    ${XSERVER_X86_FBDEV} \
    ${XSERVER_X86_VESA} \
    ${XSERVER_X86_MODESETTING} \
    ${XSERVER_X86_TOUCH} \
"

XSERVER_X86_BASE = " \
    xserver-xorg \
    xf86-input-mouse \
    xf86-input-keyboard \
    xf86-input-evdev \
    xf86-input-synaptics \
"

XSERVER_X86_EXT = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'xserver-xorg-extension-glx', '', d)} \
    xserver-xorg-module-libint10 \
"

XSERVER_X86_I915 = "xf86-video-intel \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'mesa-driver-i915', '', d)} \
"

XSERVER_X86_I965 = "xf86-video-intel \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'mesa-driver-i965', '', d)} \
"

XSERVER_X86_VESA = "xf86-video-vesa"
XSERVER_X86_FBDEV = "xf86-video-fbdev"

XSERVER_X86_TOUCH = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'touchscreen', 'xf86-input-tslib', '', d)} \
"

XSERVER_X86_MODESETTING = "xf86-video-modesetting"
 
