require recipes-core/images/emac-image.bb

DESCRIPTION = "Kiosk Image extends emac-image."

inherit update-alternatives

IMAGE_INSTALL:append = " \
    firefox \
    xdotool \
    xserver-xf86-config \
    liberation-fonts \
    xkbcomp \
    xkeyboard-config \
    libegl-mesa \
    libgles2-mesa \
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
"

FIREFOX_ARGS ?= "--width \${fbresH} --height \${fbresV} --setDefaultBrowser \$HOMEPAGE"

start_firefox() {
        echo "#!/bin/sh" > ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "xset s off" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "xset -dpms" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "xset s noblank" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
        echo >> ${IMAGE_ROOTFS}${bindir}/firefox-start
        echo "fbresH=\$(fbset | grep geometry | cut -d \" \" -f6)" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
        echo "fbresV=\$(fbset | grep geometry | cut -d \" \" -f7)" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
        echo >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "while true; do" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "xdotool search --onlyvisible --sync --class \"Firefox\" key \"F11\" &" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
        echo "/usr/bin/firefox ${FIREFOX_ARGS}" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "sleep 1" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "logger \"Firefox crashed - restarting\"" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	echo "done" >> ${IMAGE_ROOTFS}${bindir}/firefox-start
	chmod +x ${IMAGE_ROOTFS}${bindir}/firefox-start 
	ln -s ${bindir}/firefox-start ${IMAGE_ROOTFS}${bindir}/x-window-manager
        echo "#!/bin/sh" > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/homepage.sh
	echo export HOMEPAGE="http://localhost" > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/homepage.sh
	chmod +x ${IMAGE_ROOTFS}${sysconfdir}/profile.d/homepage.sh
}

ROOTFS_POSTPROCESS_COMMAND += "start_firefox;"

IMAGE_TYPE = "Firefox Kiosk"
BUILD_TYPE = "kiosk"
PART_NUMBER ?= "Standard Kiosk"
