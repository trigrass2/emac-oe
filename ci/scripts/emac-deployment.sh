eval `bitbake core-image-base -e | grep ^ARCHIVE_PATH= | sed 's|\"||g'`
tail --pid=$(cat bitbake.lock) -f /dev/null || true
export ARCHIVE_PATH=$ARCHIVE_PATH
eval `bitbake core-image-base -e | grep ^DEPLOY_DIR= | sed 's|\"||g'`
tail --pid=$(cat bitbake.lock) -f /dev/null || true
export DEPLOY_DIR=$DEPLOY_DIR
upload_oe;
upload_oe_archive;