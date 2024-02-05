eval `bitbake core-image-base -e | grep ^SSTATE_DIR= | sed 's|\"||g'`
tail --pid=$(cat bitbake.lock) -f /dev/null || true
eval `bitbake core-image-base -e | grep ^ALL_MULTILIB_PACKAGE_ARCHS= | sed 's|\"||g' | sed 's| |,|g'`
tail --pid=$(cat bitbake.lock) -f /dev/null || true
sstate-cache-management.sh -d -y --cache-dir=$SSTATE_DIR --extra-archs=$ALL_MULTILIB_PACKAGE_ARCHS