SUMMARY = "Qt for Embedded Linux (Qt without X11)"
PR = "r2"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = " \
    ${PN} \
    ${PN}-base-extras \
    ${PN}-tools \
    ${PN}-weblibs \
    ${PN}-extraslibs \
    ${@bb.utils.contains('EMAC_DISPLAY_HW', 'opengl', ' ${PN}-gstreamer  ', '', d)} \
"

# QT MODS
# SUMMARY_${PN}-qt5 = "Qt5(Full) meta package"
RDEPENDS:${PN}:append = " \
    ${PN}-base-extras \
    ${PN}-tools \
    qtbase \
    qtcharts \
    qtconnectivity \
    qtdeclarative \
    qtdeclarative-tools \
    qtgamepad \
    qtimageformats \
    qtquickcontrols \
    qtquickcontrols2 \
    qtquicktimeline \
    qtremoteobjects \
    qtsensors \
    qtserialbus \
    qtserialport \
    qtsvg \
    qttools \
    qttools-tools \
    qtimageformats \
    qtmqtt \
    ${@bb.utils.contains('EMAC_DISPLAY', 'wayland', ' qtwayland ', '', d)} \
    qtwebsockets \
    qtwebchannel \
    qtxmlpatterns \
    qtvirtualkeyboard \
    ${@bb.utils.contains('EMAC_DISPLAY_HW', ' opengl ', ' \
        ${PN}-gstreamer \
        qt3d \
        qtdatavis3d \
        qtgraphicaleffects \
        qtlocation \
        qtmultimedia \
        qtquick3d \
        qtwebglplugin ', '', d)} \
"


SUMMARY:${PN}-weblibs = "Extra qt libs that are not on the standard sysetm"
RDEPENDS:${PN}-weblibs:append = " \
    qtwebview \
    qtwebengine \
"

SUMMARY:${PN}-extraslibs = "Extra qt libs that are not on the standard sysetm"
RDEPENDS:${PN}-extraslibs:append = " \
    qttranslations \
    qtsystems \
    qtscxml \
    qtscript \
    qtquicktimeline \
    qtpurchasing \
    qtopcua \
    qtnetworkauth \
    qtlottie \
"


SUMMARY:${PN}-base-extras = "Extra tools fonts and tz data for emac qt based boards"
RDEPENDS:${PN}-base-extras:append = " \
    kernel-modules \
    ca-certificates \
    liberation-fonts \
    ttf-devanagari \
    ttf-opensans \
    ttf-dejavu-common \
    ttf-dejavu-sans \
    ttf-freefont-mono \
    ttf-tlwg \
    otf-noto \
    tzdata \
    tzdata-americas \
    tzdata-asia \
    tzdata-europe \
    rng-tools \
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "pulseaudio", "pulseaudio-server pulseaudio-misc", "", d)} \
"

SUMMARY:${PN}-tools = "Extra Tools for a qtbased company"
RDEPENDS:${PN}-tools:append = " \
    alsa-utils-amixer \
    binutils \
    binutils-symlinks \
    gcc-sanitizers \
    e2fsprogs-resize2fs \
    i2c-tools \
    iproute2 \
    ldd \
    mtd-utils \
    openssh-sftp-server \
    parted \
    procps \
    rsync \
    tslib-calibrate \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd-analyze", "", d)} \
"


## gstreamer
SUMMARY:${PN}-gstreamer = "gstreamer meta package"
MACHINE_GSTREAMER_1_0_PLUGIN ?= ""
RDEPENDS:${PN}-gstreamer = " \
    gstreamer1.0-meta-base \
    gstreamer1.0-meta-video \
    gstreamer1.0-meta-audio \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-ugly-meta \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-libav \
    ${MACHINE_GSTREAMER_1_0_PLUGIN} \
"
