SUMMARY = "Standard full-featured Emac Linux system"
DESCRIPTION = "Package group bringing in packages needed for no busybox"
PR = "r6"

inherit packagegroup

PACKAGES = "\
    packagegroup-no-busybox \
    packagegroup-no-busybox-libs \
    packagegroup-no-busybox-utils \
    packagegroup-no-busybox-networking \
    packagegroup-no-busybox-dev-utils \
    packagegroup-no-busybox-multiuser \
    packagegroup-no-busybox-initscripts \
    packagegroup-no-busybox-sys-services \
"


RDEPENDS_packagegroup-no-busybox = "\
    packagegroup-no-busybox-libs \
    packagegroup-no-busybox-utils \
    packagegroup-no-busybox-networking \
    packagegroup-no-busybox-dev-utils \
    packagegroup-no-busybox-multiuser \
    packagegroup-no-busybox-initscripts \
    packagegroup-no-busybox-sys-services \
"

# gcc-sanitizers
RDEPENDS_packagegroup-no-busybox-libs = "\
    binutils \
    binutils-symlinks \
    glib-2.0 \
"

RDEPENDS_packagegroup-no-busybox-utils = "\
    acl \
    attr \
    bash \
    bc \
    bzip2 \
    coreutils \
    cpio \
    dos2unix \
    devmem2 \
    e2fsprogs \
    ed \
    file \
    findutils \
    fbsplash \
    gawk \
    gmp \
    grep \
    gzip \
    hdparm \
    less \
    makedevs \
    mc \
    mc-fish \
    mc-helpers \
    mc-helpers-perl \
    ncurses \
    ncurses-tools \
    ncftp \
    net-tools \
    openssh-sshd openssh \
    parted \
    procps \
    pciutils \
    psmisc \
    sed \
    setserial \
    tar \
    time \
    util-linux \
    watchdog \
    which \
    xz \
"

RDEPENDS_packagegroup-no-busybox-networking = "\
    iproute2 \
    iputils \
    iptables \
    module-init-tools \
    openssl \
    ethtool \
    ca-certificates \
"
RDEPENDS_packagegroup-no-busybox-dev-utils = "\
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "alsa", " alsa-utils-amixer ", "", d)} \
    diffutils \
    m4 \
    make \
    patch \
"

VIRTUAL-RUNTIME_syslog ?= "sysklogd"
RDEPENDS_packagegroup-no-busybox-initscripts = "\
    ${VIRTUAL-RUNTIME_initscripts} \
    ${VIRTUAL-RUNTIME_init_manager} \
    ${VIRTUAL-RUNTIME_login_manager} \
    ${VIRTUAL-RUNTIME_syslog} \
    "

RDEPENDS_packagegroup-no-busybox-multiuser = "\
    adduser \
    cracklib \
    shadow \
    sudo \
"

RDEPENDS_packagegroup-no-busybox-sys-services = "\
    at \
    cronie \
    logrotate \
    ${@bb.utils.contains('DISTRO_FEATURES', 'nfs', 'nfs-utils rpcbind', '', d)} \
"
