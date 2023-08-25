DESCRIPTION = "Light browser based on the blink engine"
LICENSE = "MIT"

inherit qmake5

SRC_URI = "git://git.emacinc.com/oe/lightbrowser.git;branch=main;"

FILES:${PN}:append = " \
    ${libdir}/* \
    /opt/* \
    /usr/bin/* \
"

S = "${WORKDIR}/build"
QMAKE_PROFILES = "${WORKDIR}/lightbrowser.pro"

DEPENDS = " \
    qttools\
    qtbase \
    qtquickcontrols \
    qtquickcontrols2 \
    qtdeclarative \
    qtvirtualkeyboard \
    qtwebengine \
    qtwayland \
"



