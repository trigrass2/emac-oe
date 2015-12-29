SUMMARY = "Vi IMproved - enhanced vi editor"
SECTION = "console/utils"
DEPENDS = "ncurses"
LICENSE = "vim"
LIC_FILES_CHKSUM = "file://../runtime/doc/uganda.txt;md5=b779e18be6ed77facc770691c967b8f8"

SRC_URI = "hg://vim.googlecode.com/hg/;protocol=https;module=vim \
           file://disable_acl_header_check.patch;patchdir=.. \
           file://vim-add-knob-whether-elf.h-are-checked.patch;patchdir=.. \
           file://vimrc.sample"

SRCREV = "v7-4-481"

SRC_URI[md5sum] = "43148e0b7fc0457386b41edb70f243b4"
SRC_URI[sha256sum] = "037a103ba341e2af960b30f678c25bd0e7b8f6fcd811fb1149830b0dcf2199a1"

S = "${WORKDIR}/${PN}/src"

VIMDIR = "${PN}${@d.getVar('PV',1).split('.')[0]}${@d.getVar('PV',1).split('.')[1]}"

inherit autotools update-alternatives
inherit autotools-brokensep

# vim configure.in contains functions which got 'dropped' by autotools.bbclass
do_configure () {
    rm -rf auto/
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
    vim_cv_tgent=non-zero \
    vim_cv_toupper_broken=no \
    vim_cv_tty_group=world \
    STRIP=/bin/true \
"

do_install() {
        oe_runmake DESTDIR='${WORKDIR}/image' installvimbin
        install -d ${D}${datadir}/${PN}/
	install -d ${D}${datadir}/${PN}/vim74
	install -d ${D}${datadir}/${PN}/vim74/syntax
	install -d ${D}${datadir}/${PN}/vim74/doc
        install -m 0644 ${WORKDIR}/vimrc.sample ${D}/${datadir}/${PN}/vimrc
        install -m 0644 ${WORKDIR}/${PN}/runtime/filetype.vim ${D}/${datadir}/${PN}/vim74/filetype.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/sh.vim ${D}/${datadir}/${PN}/vim74/syntax/sh.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/html.vim ${D}/${datadir}/${PN}/vim74/syntax/html.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/2html.vim ${D}/${datadir}/${PN}/vim74/syntax/2html.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/awk.vim ${D}/${datadir}/${PN}/vim74/syntax/awk.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/cfg.vim ${D}/${datadir}/${PN}/vim74/syntax/cfg.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/conf.vim ${D}/${datadir}/${PN}/vim74/syntax/conf.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/config.vim ${D}/${datadir}/${PN}/vim74/syntax/config.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/crontab.vim ${D}/${datadir}/${PN}/vim74/syntax/crontab.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/diff.vim ${D}/${datadir}/${PN}/vim74/syntax/diff.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/django.vim ${D}/${datadir}/${PN}/vim74/syntax/django.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/dtd.vim ${D}/${datadir}/${PN}/vim74/syntax/dtd.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/expect.vim ${D}/${datadir}/${PN}/vim74/syntax/expect.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/fstab.vim ${D}/${datadir}/${PN}/vim74/syntax/fstab.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/group.vim ${D}/${datadir}/${PN}/vim74/syntax/group.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/help.vim ${D}/${datadir}/${PN}/vim74/syntax/help.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/hostconf.vim ${D}/${datadir}/${PN}/vim74/syntax/hostconf.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/indent.vim ${D}/${datadir}/${PN}/vim74/syntax/indent.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/inittab.vim ${D}/${datadir}/${PN}/vim74/syntax/inittab.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/lilo.vim ${D}/${datadir}/${PN}/vim74/syntax/lilo.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/limits.vim ${D}/${datadir}/${PN}/vim74/syntax/limits.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/messages.vim ${D}/${datadir}/${PN}/vim74/syntax/messages.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/modconf.vim ${D}/${datadir}/${PN}/vim74/syntax/modconf.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/passwd.vim ${D}/${datadir}/${PN}/vim74/syntax/passwd.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/perl.vim ${D}/${datadir}/${PN}/vim74/syntax/perl.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/php.vim ${D}/${datadir}/${PN}/vim74/syntax/php.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/protocols.vim ${D}/${datadir}/${PN}/vim74/syntax/protocols.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/python.vim ${D}/${datadir}/${PN}/vim74/syntax/python.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/rc.vim ${D}/${datadir}/${PN}/vim74/syntax/rc.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/rcs.vim ${D}/${datadir}/${PN}/vim74/syntax/rcs.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/readline.vim ${D}/${datadir}/${PN}/vim74/syntax/readline.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/resolv.vim ${D}/${datadir}/${PN}/vim74/syntax/resolv.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/robots.vim ${D}/${datadir}/${PN}/vim74/syntax/robots.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/samba.vim ${D}/${datadir}/${PN}/vim74/syntax/samba.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/services.vim ${D}/${datadir}/${PN}/vim74/syntax/services.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/setserial.vim ${D}/${datadir}/${PN}/vim74/syntax/setserial.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/sshconfig.vim ${D}/${datadir}/${PN}/vim74/syntax/sshconfig.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/sshdconfig.vim ${D}/${datadir}/${PN}/vim74/syntax/sshdconfig.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/sudoers.vim ${D}/${datadir}/${PN}/vim74/syntax/sudoers.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/udevconf.vim ${D}/${datadir}/${PN}/vim74/syntax/udevconf.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/udevperm.vim ${D}/${datadir}/${PN}/vim74/syntax/udevperm.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/udevrules.vim ${D}/${datadir}/${PN}/vim74/syntax/udevrules.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/vim.vim ${D}/${datadir}/${PN}/vim74/syntax/vim.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/wget.vim ${D}/${datadir}/${PN}/vim74/syntax/wget.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/nosyntax.vim ${D}/${datadir}/${PN}/vim74/syntax/nosyntax.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/syntax.vim ${D}/${datadir}/${PN}/vim74/syntax/syntax.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/vim.vim ${D}/${datadir}/${PN}/vim74/syntax/vim.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/syncolor.vim ${D}/${datadir}/${PN}/vim74/syntax/syncolor.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/synload.vim ${D}/${datadir}/${PN}/vim74/syntax/synload.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/javascript.vim ${D}/${datadir}/${PN}/vim74/syntax/javascript.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/css.vim ${D}/${datadir}/${PN}/vim74/syntax/css.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/vb.vim ${D}/${datadir}/${PN}/vim74/syntax/vb.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/syntax/sql.vim ${D}/${datadir}/${PN}/vim74/syntax/sql.vim
        install -m 0644 ${WORKDIR}/${PN}/runtime/doc/tags ${D}/${datadir}/${PN}/vim74/doc/tags
        install -m 0644 ${WORKDIR}/${PN}/runtime/doc/help.txt ${D}/${datadir}/${PN}/vim74/doc/help.txt
}

PARALLEL_MAKEINST = ""

ALTERNATIVE_${PN} = "vi"
ALTERNATIVE_TARGET[vi] = "${bindir}/${PN}"
ALTERNATIVE_LINK_NAME[vi] = "${base_bindir}/vi"
ALTERNATIVE_PRIORITY[vi] = "100"

