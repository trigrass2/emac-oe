############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
##
## Copyright (C) 2016 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
##
###########################################################################
inherit populate_sdk
SDK_DEPLOY = "${TMPDIR}/deploy/sdk/${MACHINE}"
quiet_sdk_extraction() {
EXTRA_TAR_OPTIONS="$EXTRA_TAR_OPTIONS --checkpoint=9999999"
}
SDK_PRE_INSTALL_COMMAND = "${quiet_sdk_extraction}"

replace_sysroot_symlink() {
        SYMLINK_SYSROOT=$1
        SEARCH_FOLDER=$2
        for SOURCE in `find ${SEARCH_FOLDER} -type l`
        do
                TARGET=`readlink -m "${SOURCE}"`
                #check whether TARGET is inside the sysroot when not prepend the sysroot
                TARGET=`echo ${TARGET} | grep "^${SYMLINK_SYSROOT}" || echo ${SYMLINK_SYSROOT}${TARGET}`
                rm "${SOURCE}"
                if [ -f "${TARGET}" ]; then
                        cp "${TARGET}" "${SOURCE}"
                elif [ -e "${TARGET}" ]; then
                        touch "${SOURCE}"
                fi
        done
}

do_populate_sdk[depends] += " p7zip-native:do_populate_sysroot "
