require recipes-core/images/emac-image.bb

DESCRIPTION = "Kiosk Image extends emac-image."

inherit update-alternatives

IMAGE_INSTALL:append = "\
    chromium-x11 \
    xserver-xf86-config \
    liberation-fonts \
    xkbcomp \
    xkeyboard-config \
    libegl-mesa \
    libgles2-mesa \
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
"

CHROME_ARGS ?= "--no-sandbox --kiosk --no-first-run --incognito \$HOMEPAGE"

start_chromium() {
        echo "#!/bin/sh" > ${IMAGE_ROOTFS}${bindir}/chromium-start
	echo "xset s off" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
	echo "xset -dpms" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
	echo "xset s noblank" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
        echo >> ${IMAGE_ROOTFS}${bindir}/chromium-start
	echo "while true; do" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
        echo "chromium ${CHROME_ARGS}" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
	echo "sleep 1" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
	echo "done" >> ${IMAGE_ROOTFS}${bindir}/chromium-start
	chmod +x ${IMAGE_ROOTFS}${bindir}/chromium-start 
	ln -s ${bindir}/chromium-start ${IMAGE_ROOTFS}${bindir}/x-window-manager
        echo "#!/bin/sh" > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/homepage.sh
	echo export HOMEPAGE="http://localhost" > ${IMAGE_ROOTFS}${sysconfdir}/profile.d/homepage.sh
	chmod +x ${IMAGE_ROOTFS}${sysconfdir}/profile.d/homepage.sh
}

ROOTFS_POSTPROCESS_COMMAND:append = " start_chromium; "

IMAGE_TYPE = "Chromium Kiosk"
BUILD_TYPE = "kiosk"
PART_NUMBER ?= "Standard Kiosk"
