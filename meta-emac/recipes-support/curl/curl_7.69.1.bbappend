# This CVE causes errors and is to be removed in later updates
# Please review the bb file for updates and remove this append when fixed.
# https://git.yoctoproject.org/poky/tree/meta/recipes-support/curl/curl_7.69.1.bb
SRC_URI_remove = "file://CVE-2023-27534.patch"