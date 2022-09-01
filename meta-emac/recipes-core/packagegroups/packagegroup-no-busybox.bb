SUMMARY = "Standard full-featured Emac Linux system"
DESCRIPTION = "Package group bringing in packages needed for no busybox"
PR = "r6"
PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
PROVIDES = "${PACKAGES}"
PACKAGES = "\
    ${PN} \
    ${PN}-utils \
    ${PN}-networking \
    ${PN}-dev-utils \
    ${PN}-multiuser \
    ${PN}-initscripts \
    ${PN}-sys-services \
"


RRECOMMENDS:${PN} = "\
    ${PN}-utils \
    ${PN}-networking \
    ${PN}-dev-utils \
    ${PN}-multiuser \
    ${PN}-initscripts \
    ${PN}-sys-services \
"

# gcc-sanitizers
#RRECOMMENDS:${PN}-libs = "
#    binutils 
#    binutils-symlinks 
#    glib-2.0 
#"

RRECOMMENDS:${PN}-utils = "\
    acl \
    attr \
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

RRECOMMENDS:${PN}-networking = "\
    iproute2 \
    iputils \
    iptables \
    module-init-tools \
    openssl \
    ethtool \
    ca-certificates \
"

RRECOMMENDS:${PN}-dev-utils = "\
    ${@bb.utils.contains("EMAC_AUDIOMANAGER", "alsa", " alsa-utils-amixer ", "", d)} \
    diffutils \
    m4 \
    make \
    patch \
"


VIRTUAL-RUNTIME_syslog = "sysklogd"
RRECOMMENDS:${PN}-initscripts = "\
    ${VIRTUAL-RUNTIME_initscripts} \
    ${VIRTUAL-RUNTIME_init_manager} \
    ${VIRTUAL-RUNTIME_login_manager} \
    ${VIRTUAL-RUNTIME_syslog} \
"

RRECOMMENDS:${PN}-multiuser = "\
    cracklib \
    shadow \
    sudo \
"

RRECOMMENDS:${PN}-sys-services = "\
    at \
    cronie \
    logrotate \
    ${@bb.utils.contains('DISTRO_FEATURES', 'nfs', 'nfs-utils rpcbind', '', d)} \
"
