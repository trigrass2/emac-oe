DESCRIPTION = "Emac Target Qt5 SDK"
LICENSE = "CLOSED"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

MACHINE_EXTRA_INSTALL_SDK ?= " "

OGL_RUNTIME_DEV ?= " ogl-runtime-dev "
OGL_RUNTIME_DEV_mipsarch ?= ""
GCC-SANITIZERS ?= "gcc-sanitizers"
GCC-SANITIZERS_mipsarch = ""
GCC-SANITIZERS_libc-musl = ""

RDEPENDS_${PN} += " \
    ${MACHINE_EXTRA_INSTALL_SDK} \
    packagegroup-core-standalone-sdk-target \
    ${GCC-SANITIZERS} \
    ${OGL_RUNTIME_DEV} \
    qtbase-dev \
    qtbase-staticdev \
    qtbase-doc \
    qtcharts-dev \
    qtconnectivity-dev \
    qtdeclarative-dev \
    qtdeclarative-staticdev \
    qtgamepad-dev \
    qtimageformats-dev \
    qtquickcontrols-dev \
    qtquickcontrols2-dev \
    qtquicktimeline-dev \
    qtremoteobjects-dev \
    qtscxml-dev \
    qtsensors-dev \
    qtserialbus-dev \
    qtserialport-dev \
    qtsvg-dev \
    qttools-dev \
    qttools-staticdev \
    qtvirtualkeyboard-dev \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland-dev', '', d)} \
    qtwebsockets-dev \
    qtwebchannel-dev \
    qtxmlpatterns-dev \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' \
	    qt3d-dev \
	    qtdatavis3d-dev \
	    qtgraphicaleffects-dev \
	    qtlocation-dev \
	    qtmultimedia-dev \
	    qtquick3d-dev ', '', d)} \
"

# qtwebview-dev
RDEPENDS_${PN}_atom-sbc += " \
    qtwebengine-dev \
"
