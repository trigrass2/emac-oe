SUMMARY = "${DESCRIPTION}"
DESCRIPTION = "A console-only server image with more full-featured Linux system \
functionality installed, and the emac user."
LICENSE = "MIT"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base-zeroconf \
    bash-completion \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
inherit extrausers

IMAGE_INSTALL:append = " adduser"

#This password is generated with `openssl passwd -6 emac_inc`, where -6 stands for SHA-512 hashing alorithgm
#The resulting string is in format $<ALGORITHM_ID>$<SALT>$<PASSWORD_HASH>, the dollar signs have been escaped
#This'll allow user to login with the least secure password there is, "emac_inc" (without quotes)
PASSWD = "\$6\$qcE7LSheDlRVevkX\$iUvx/gt8wfvyneh7ce8idQqU.HZ4Uh2pKSnaMz.erlCllENj9MzF4oBWkRN/fcQclO7DTdAPLqPjPpz6Yjy27."

#This creates a user with name emac and UID 1200. The password is stored in the aforementioned PASSWD variable, and home-folder
#is /home/emac, and the login-shell is set as sh. Finally, this user is added to the sudo-group.
EXTRA_USERS_PARAMS = "\
    useradd -u 1200 -d /home/emac -s /bin/sh -p '${PASSWD}' emac; \
    usermod -a -G sudo emac; \
"
