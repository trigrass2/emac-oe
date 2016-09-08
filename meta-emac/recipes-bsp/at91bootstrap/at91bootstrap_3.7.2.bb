require at91bootstrap.inc

SRC_URI = "https://github.com/linux4sam/at91bootstrap/archive/v${PV}.tar.gz;name=tarball \
	   file://0001-64MB-ram.patch \
	   file://0002-spi-flash.patch \
	   file://0003-9g45-ram.patch \
	   file://0004-9g45-pb18.patch \
          "
SRC_URI[tarball.md5sum] = "bde892326211cfe739e41edea2f3c5d9"
SRC_URI[tarball.sha256sum] = "c6ee66fc4dc500140633868845d0fb59bd32e010ec886bd7da1af7af06664cfa"
