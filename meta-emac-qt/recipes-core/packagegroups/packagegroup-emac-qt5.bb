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
    ${PN}-gstreamer \
"

# QT MODS
# SUMMARY_${PN}-qt5 = "Qt5(Full) meta package"
RDEPENDS_${PN} += " \
    ${PN}-base-extras \
    ${PN}-tools \
    ${PN}-gstreamer \
    qt3d \
    qtbase \
    qtcharts \
    qtconnectivity \
    qtdatavis3d \
    qtdeclarative \
    qtdeclarative-tools \
    qtgamepad \
    qtgraphicaleffects \
    qtimageformats \
    qtlocation \
    qtmultimedia \
    qtquick3d \
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
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland', '', d)} \
    qtwebsockets \
    qtwebchannel \
    qtwebglplugin \
    qtxmlpatterns \
    qtvirtualkeyboard \
"


## TODO ADD connman
SUMMARY_${PN}-base-extras = "Extra tools fonts and tz data for emac qt based boards"
RDEPENDS_${PN}-base-extras += " \
    kernel-modules \
    linux-firmware \
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
    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "weston weston-init weston-examples", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "pulseaudio", "pulseaudio-server pulseaudio-misc", "", d)} \
"

# TOOLS for developers to use on the system.  Most if not all are needed by qt
# connman-client
SUMMARY_${PN}-tools = "Extra Tools for a qtbased company"
RDEPENDS_${PN}-tools += " \
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
SUMMARY_${PN}-gstreamer = "gstreamer meta package"
MACHINE_GSTREAMER_1_0_PLUGIN ?= ""
RDEPENDS_${PN}-gstreamer = " \
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
