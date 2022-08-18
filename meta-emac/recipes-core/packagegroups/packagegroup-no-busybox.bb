SUMMARY = "Standard full-featured Emac Linux system"
DESCRIPTION = "Package group bringing in packages needed for no busybox"
PR = "r6"
PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-no-busybox \
    packagegroup-no-busybox-utils \
    packagegroup-no-busybox-networking \
    packagegroup-no-busybox-dev-utils \
    packagegroup-no-busybox-multiuser \
    packagegroup-no-busybox-initscripts \
    packagegroup-no-busybox-sys-services \
"


RRECOMMENDS:packagegroup-no-busybox = "\
    packagegroup-no-busybox-utils \
    packagegroup-no-busybox-networking \
    packagegroup-no-busybox-dev-utils \
    packagegroup-no-busybox-multiuser \
    packagegroup-no-busybox-initscripts \
    packagegroup-no-busybox-sys-services \
"

# gcc-sanitizers
#RRECOMMENDS:packagegroup-no-busybox-libs = "
#    binutils 
#    binutils-symlinks 
#    glib-2.0 
#"

RRECOMMENDS:packagegroup-no-busybox-utils = "\
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

RRECOMMENDS:packagegroup-no-busybox-networking = "\
    iproute2 \
    iputils \
    iptables \
    module-init-tools \
    openssl \
    ethtool \
    ca-certificates \
"

RRECOMMENDS:packagegroup-no-busybox-dev-utils = "\
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "alsa", " alsa-utils-amixer ", "", d)} \
    diffutils \
    m4 \
    make \
    patch \
"


VIRTUAL-RUNTIME_syslog = "sysklogd"
RRECOMMENDS:packagegroup-no-busybox-initscripts = "\
    ${VIRTUAL-RUNTIME_initscripts} \
    ${VIRTUAL-RUNTIME_init_manager} \
    ${VIRTUAL-RUNTIME_login_manager} \
    ${VIRTUAL-RUNTIME_syslog} \
"

RRECOMMENDS:packagegroup-no-busybox-multiuser = "\
    cracklib \
    shadow \
    sudo \
"

RRECOMMENDS:packagegroup-no-busybox-sys-services = "\
    at \
    cronie \
    logrotate \
    ${@bb.utils.contains('DISTRO_FEATURES', 'nfs', 'nfs-utils rpcbind', '', d)} \
"
