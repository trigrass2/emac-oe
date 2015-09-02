#
# Copyright (C) 2014  EMAC Inc, All rights reserved
#

DESCRIPTION = "EMAC Extra Package Groups"
LICENSE = "GPLv2"
PR = "r0"

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

RDEPENDS_${PN} = "\
    ${PN}-util-base \
    ${PN}-util-networking \
    ${PN}-util-debug \
    ${PN}-timezone \
    "

SUMMARY_${PN}-util-base = "EMAC OE Extra Utilities"
RDEPENDS_${PN}-util-base = "\
    tftp-hpa \
    wget \
    lighttpd \
    ntpdate \
    libstdc++ \
    sqlite3 \
    inotify-tools \
    "

SUMMARY_${PN}-util-networking = "EMAC OE Extra Utilities"
RDEPENDS_${PN}-util-networking = "\
    iptables \
    tcpdump \
    bind-utils \
    nfs-utils-client \
    ethtool \
    iproute2 \
    "

SUMMARY_${PN}-util-debug = "EMAC OE Extra Utilities"
RDEPENDS_${PN}-util-debug = "\
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
    "

SUMMARY_${PN}-timezone = "EMAC OE TimeZone Files"
RDEPENDS_${PN}-timezone = "\
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
