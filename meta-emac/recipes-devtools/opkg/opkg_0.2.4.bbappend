FILESEXTRAPATHS_append := "${THISDIR}/${BPN}:"

SRC_URI_append = "file://update-error-message.patch \
           file://remove-error-message.patch \
"
OPKGLOCKFILE = "${target_localstatedir}/lock/opkg_lock"

EXTRA_OECONF_append = "\
  --with-opkglockfile=${OPKGLOCKFILE} \
"
