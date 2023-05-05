DESCRIPTION = "EMAC Sound Test" 
SECTION = "testing" 
LICENSE = "CLOSED" 
PR = "r0" 

DEPENDS = "libsndfile1"
RDEPENDS:${PN} = "libsndfile1"

SRCREV = "30fc35ab79e26c64ad7b74062cd4491d92fab971"

SRC_URI = "\
    git://git@git.emacinc.com/FunctionalTest/FFT-Audio-Test.git;protocol=ssh;branch=master \
"

S = "${WORKDIR}/git"

inherit cmake 

do_install() {
    install -d ${D}${bindir}
    install -m 0755 fft_sound_test ${D}${bindir}
}
