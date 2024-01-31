# KAS checks out the root repo at build/layers
# This script will remap that to the topdir git repo for easier development
TOP="$(git rev-parse --show-toplevel)"
sed -i "s|\${TOPDIR}/layers/$(basename ${TOP})/|${TOP}/|g" "${TOP}"/build/conf/bblayers.conf
