SUMMARY = "Vi IMproved - enhanced vi editor"
SECTION = "console/utils"
DEPENDS = "ncurses"
LICENSE = "vim"
LIC_FILES_CHKSUM = "file://../runtime/doc/uganda.txt;md5=eea32ac1424bba14096736a494ae9045"

SRC_URI = "git://github.com/vim/vim.git \
           file://configure.patch;patchdir=.. \
           file://vimrc.sample"

SRCREV = "353eeeaca269ed5e83900bd4a24dc6dc80bb4880"

SRCDIR = "${WORKDIR}/git"
S = "${SRCDIR}/src"

#VIMDIR = "${BPN}${@d.getVar('PV',1).split('.')[1]}${@d.getVar('PV',1).split('.')[2]}"
VIMDIR = "vim${@d.getVar('PV').split('.')[0]}${@d.getVar('PV').split('.')[1]}"

inherit autotools update-alternatives
inherit autotools-brokensep

# vim configure.in contains functions which got 'dropped' by autotools.bbclass
do_configure () {
    rm -rf auto/*
    mkdir -p auto
    touch auto/config.mk
    aclocal
    autoconf
    oe_runconf
    touch auto/configure
    touch auto/config.mk auto/config.h
}

EXTRA_OECONF = " \
    --disable-gpm \
    --disable-gtktest \
    --disable-xim \
    --disable-netbeans \
    --with-tlib=ncurses \
    --disable-acl \
    --enable-gui=no \
    --without-x \
    ac_cv_small_wchar_t=no \
    vim_cv_getcwd_broken=no \
    vim_cv_memmove_handles_overlap=yes \
    vim_cv_stat_ignores_slash=no \
    vim_cv_terminfo=yes \
    vim_cv_tgetent=non-zero \
    vim_cv_toupper_broken=no \
    vim_cv_tty_group=world \
    STRIP=/bin/true \
"

do_install() {
        oe_runmake DESTDIR='${WORKDIR}/image' installvimbin
	install -d ${D}${datadir}/${BPN}/${VIMDIR}/syntax
	install -d ${D}${datadir}/${BPN}/${VIMDIR}/doc
	install -d ${D}${datadir}/${BPN}/${VIMDIR}/autoload/dist
        install -m 0644 ${WORKDIR}/vimrc.sample ${D}/${datadir}/${PN}/vimrc
        install -m 0644 ${SRCDIR}/runtime/rgb.txt ${D}/${datadir}/${BPN}/${VIMDIR}/rgb.txt
        install -m 0644 ${SRCDIR}/runtime/filetype.vim ${D}/${datadir}/${BPN}/${VIMDIR}/filetype.vim
	install -m 0644 ${SRCDIR}/runtime/syntax/sh.vim ${D}/${datadir}/${PN}/${VIMDIR}/syntax/sh.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/html.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/html.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/2html.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/2html.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/awk.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/awk.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/cfg.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/cfg.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/conf.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/conf.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/config.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/config.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/crontab.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/crontab.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/diff.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/diff.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/fstab.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/fstab.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/group.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/group.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/help.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/help.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/hostconf.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/hostconf.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/indent.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/indent.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/inittab.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/inittab.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/limits.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/limits.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/messages.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/messages.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/modconf.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/modconf.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/passwd.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/passwd.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/perl.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/perl.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/php.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/php.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/protocols.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/protocols.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/python.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/python.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/readline.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/readline.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/resolv.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/resolv.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/samba.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/samba.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/services.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/services.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/sshconfig.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/sshconfig.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/sshdconfig.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/sshdconfig.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/udevrules.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/udevrules.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/nosyntax.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/nosyntax.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/syntax.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/syntax.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/vim.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/vim.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/syncolor.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/syncolor.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/synload.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/synload.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/javascript.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/javascript.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/css.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/css.vim
        install -m 0644 ${SRCDIR}/runtime/syntax/sql.vim ${D}/${datadir}/${BPN}/${VIMDIR}/syntax/sql.vim
        install -m 0644 ${SRCDIR}/runtime/doc/tags ${D}/${datadir}/${BPN}/${VIMDIR}/doc/tags
        install -m 0644 ${SRCDIR}/runtime/doc/help.txt ${D}/${datadir}/${BPN}/${VIMDIR}/doc/help.txt
	install -m 0644 ${SRCDIR}/runtime/autoload/dist/ft.vim ${D}${datadir}/${BPN}/${VIMDIR}/autoload/dist/ft.vim
}

PARALLEL_MAKEINST = ""

ALTERNATIVE_${PN} = "vi"
ALTERNATIVE_TARGET[vi] = "${bindir}/${BPN}"
ALTERNATIVE_LINK_NAME[vi] = "${base_bindir}/vi"
ALTERNATIVE_PRIORITY[vi] = "100"
