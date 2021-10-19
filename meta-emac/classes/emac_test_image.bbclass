inherit testimage

# Add boot patterns to use with OE testimage infrastructure with the serial console
TESTIMAGE_BOOT_PATTERNS = "search_reached_prompt send_login_user"

# Look for EMAC OE to check when the device has booted
TESTIMAGE_BOOT_PATTERNS[search_reached_prompt] ?= " EMAC OE"

# Use carriage return as the user to "log in"
TESTIMAGE_BOOT_PATTERNS[send_login_user] ?= "\r"


# logrotate connman systemd oe_syslog pam xorg rpm opkg apt weston parselogs gcc
BASICTESTSUITE = " \
    ping \
    date \
    df \
    ssh \
    scp \
    python \
    perl \
    gi \
    ptest  \
    stap \
    ldd  \
    kernelmodule \
    buildcpio \
    buildlzip \
    buildgalculator \
    dnf \
"



