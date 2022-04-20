# Copyright (C) 2022 EMAC, Inc.
# Released under the GPLv2 license

SUMMARY = "Add www user and group for webserver security."
LICENSE = "GPLv2"

inherit extrausers

EXTRA_USERS_PARAMS = " \
            useradd -M -U www-data; \
            "

do_install() {
    install -d ${D}${localstatedir}/www
    install -d ${D}/www
    chown -R www-data:www-data ${D}${localstatedir}/www/
    chown -R www-data:www-data ${D}/www/
}
