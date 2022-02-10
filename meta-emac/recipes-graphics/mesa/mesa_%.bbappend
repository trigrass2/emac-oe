## for the atom(intel board lets make sure that we get opengl from the i915)
DRIDRIVERS_atom-sbc-64 = "r100,r200,nouveau,i915,i965"
## these drivers will be coming soon d3d12,crocus
GALLIUMDRIVERS_atom-sbc-64 = "swrast,r300,r600,nouveau,virgl,svga,iris"
PLATFORMS_atom-sbc-64 = "x11 wayland drm"
PACKAGECONFIG_class-target="wayland opengl egl gles gbm dri gallium virgl x11 dri3 elf-tls osmesa unwind"



# confflags_GALLIUM += 


# 	confflags_GALLIUM += -Dgallium-vdpau=enabled
# 	confflags_GALLIUM += -Dlmsensors=enabled


## LLVM FIXME 
# radeonsi 


# -Dgallium-extra-hud=true
# -Dgallium-vdpau=enabled
# -Dlmsensors=enabled
# -Dgallium-xa=enabled
# -Dvalgrind=enabled
# -Dllvm=disabled
# EXTRA_OEMESON
# -Dshared-glapi=true     
# -Dgallium-opencl=disabled     
# -Dglx-read-only-text=true     
# -Dplatforms='wayland,x11,drm,surfaceless'   
# -Ddri=true 
# -Ddri-drivers=,r100,r200,nouveau,i965,i915 
# -Ddri3=true 
# -Degl=true 
# -Delf-tls=true 
# -Dgallium-drivers=i915,iris,,virgl  
# -Dllvm=false 
# -Dgbm=true 
# -Dgles1=true 
# -Dgles2=true 
# -Dopengl=true 
# -Dosmesa=true 
# -Dlibunwind=true  
# -Dvulkan-drivers=''  
# -Dgallium-xa=false 
# -Dgallium-xvmc=false 
# -Dasm=false"
