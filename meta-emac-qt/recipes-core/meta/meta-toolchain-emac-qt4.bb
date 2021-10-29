SUMMARY = "Meta package for building a qt4 installable toolchain"
LICENSE = "MIT"
PR = "r8"

inherit populate_emacqt4_sdk

TOOLCHAIN_TARGET_TASK_append = " \
    linux-libc-headers-dev \
    libusb1-dev \
    confuse-dev \
    libgpiod-dev \
    libmodbus-dev \
    boost-dev \
"

MACHINE_EXTRA_INSTALL_SDK_HOST ?= ""
TOOLCHAIN_HOST_TASK_append = " \
    nativesdk-qt4-tools \
    nativesdk-cmake \
    nativesdk-perl-modules \
    nativesdk-make \
    nativesdk-autoconf-archive \
    nativesdk-python-core \
    nativesdk-python-textutils \
    nativesdk-python-sqlite3 \
    nativesdk-python-pickle \
    nativesdk-python-logging \
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
    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "nativesdk-wayland-dev", "", d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-qtwayland-tools', '', d)} \
    ${MACHINE_EXTRA_INSTALL_SDK_HOST} \
"

