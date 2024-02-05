# Replace busybox
PREFERRED_PROVIDER_virtual/base-utils = "packagegroup-core-base-utils"
VIRTUAL-RUNTIME_base-utils = "packagegroup-core-base-utils"
VIRTUAL-RUNTIME_base-utils-hwclock = "util-linux-hwclock"
VIRTUAL-RUNTIME_base-utils-syslog = ""

SKIP_RECIPE[busybox] ?= "${@bb.utils.contains('INIT_MANAGER', 'systemd', 'Dont build this with systemd', '', d)}"
