#
# Copyright (C) 2014  EMAC Inc, All rights reserved
#

DESCRIPTION = "EMAC Extra Package Groups"
LICENSE = "GPLv2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = "\
    ${PN} \
    ${PN}-util-base \
    ${PN}-util-networking \
    ${PN}-util-debug \
    ${PN}-timezone \
"

RRECOMMENDS_${PN} = "\
    ${PN}-util-base \
    ${PN}-util-networking \
    ${PN}-util-debug \
    ${PN}-timezone \
"

SUMMARY_${PN}-util-base = "EMAC OE Extra Utilities"
RRECOMMENDS_${PN}-util-base = " \
    tftp-hpa \
    wget \
    libstdc++ \
    sqlite3 \
    inotify-tools \
    lighttpd \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "systemd-analyze", "", d)} \
"


SUMMARY_${PN}-util-networking = "EMAC OE Extra Utilities"
RRECOMMENDS_${PN}-util-networking = " \
    iptables \
    tcpdump \
    ntpdate \
    bind-utils \
    nfs-utils-client \
    ethtool \
    iproute2 \
"

SUMMARY_${PN}-util-debug = "EMAC OE Extra Utilities"
RRECOMMENDS_${PN}-util-debug = " \
    gdbserver \
    strace \
    memtester \
    evtest \
    htop \
    minicom \
    vim \
    openssh-sftp \
    openssh-sftp-server \
    file \
    emac-tools \
    sshpass \
    procps \
    nano \
    md5deep \
    ldd \
"


SUMMARY_${PN}-timezone = "EMAC OE TimeZone Files"
RRECOMMENDS_${PN}-timezone = " \
    tzdata \
    tzdata-africa \
    tzdata-americas \
    tzdata-antarctica \
    tzdata-arctic \
    tzdata-asia \
    tzdata-atlantic \
    tzdata-australia \
    tzdata-europe \
    tzdata-pacific \
"


# parted
# i2c-tools
# spidev-test
