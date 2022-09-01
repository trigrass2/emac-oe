## for the atom(intel board lets make sure that we get opengl from the i915)
DRIDRIVERS:atom-sbc-64 = "r100,r200,nouveau,i915,i965"
## these drivers will be coming soon d3d12,crocus
GALLIUMDRIVERS:atom-sbc-64 = "swrast,r300,r600,nouveau,virgl,svga,iris"
PLATFORMS:atom-sbc-64 = "x11 wayland drm"
PACKAGECONFIG:class-target="wayland opengl egl gles gbm dri gallium virgl x11 dri3 elf-tls osmesa unwind"
