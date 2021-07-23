PACKAGECONFIG += "${@bb.utils.filter('DISTRO_FEATURES', 'alsa pulseaudio gstreamer', d)}"
