## Checking for GStreamer i.MX common... no
PACKAGECONFIG:append = "${@bb.utils.filter('DISTRO_FEATURES', ' alsa pulseaudio gstreamer ', d)}"







