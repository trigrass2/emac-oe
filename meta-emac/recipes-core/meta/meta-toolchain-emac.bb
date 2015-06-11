# A image used to populate the toolchain
QTNAME = "qte"
QT_DIR_NAME = "qtopia"

TOOLCHAIN_TARGET_TASK_append = " packagegroup-emac-toolchain-target"

TOOLCHAIN_HOST_TASK_append = " \
    nativesdk-python-core \
    nativesdk-python-textutils \
    nativesdk-python-sqlite3 \
    nativesdk-python-pickle \
    nativesdk-python-logging \
    nativesdk-python-elementtree \
    nativesdk-python-curses \
    nativesdk-python-compile \
    nativesdk-python-compiler \
    nativesdk-python-fcntl \
    nativesdk-python-shell \
    nativesdk-python-misc \
    nativesdk-python-multiprocessing \
    nativesdk-python-subprocess \
    nativesdk-python-xmlrpc \
    nativesdk-python-netclient \
    nativesdk-python-netserver \
    nativesdk-python-distutils \
    nativesdk-python-unixadmin \
    nativesdk-python-compression \
    nativesdk-python-json \
    nativesdk-python-unittest \
    nativesdk-python-mmap \
    nativesdk-python-difflib \
    nativesdk-python-pprint \
    nativesdk-python-pkgutil \
"

require recipes-qt/meta/meta-toolchain-qt.inc
