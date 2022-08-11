# Version 1.6
SRCREV = "f5937e0b20e2c9d30776c389319b7dfaff9fd34f"
PE = "1"

SRC_URI = "git://git.kernel.org/pub/scm/utils/rt-tests/rt-tests.git"
# 1.2 and 1.3 seem to be development versions
UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>(?!1\.2)(?!1\.3)(\d+(\.\d+)+))"

S = "${WORKDIR}/git"

# calling 'uname -m' is broken on crossbuilds
EXTRA_OEMAKE = "NUMA=0"
