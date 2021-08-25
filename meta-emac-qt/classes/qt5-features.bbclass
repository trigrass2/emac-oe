############################################################################
##
## Copyright (C) 2021 Emacs inc.
## Contact: https://www.emacinc.com
##
## Copyright (C) 2018 The Qt Company Ltd.
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

FEATURES := "${THISDIR}/features/${QT_MODULE}.opt"
do_configure[file-checksums] += "${FEATURES}:True"

def qt_features(d):
    featurefile = d.getVar('FEATURES')
    with open(featurefile, 'r') as f:
        features = f.read().replace('\n', ' ')
    return features

QT_CONFIG_FLAGS_append_class-target = " ${@qt_features(d)}"
EXTRA_QMAKEVARS_CONFIGURE_append_class-target = " ${@qt_features(d)}"
