# Yocto ADT Installer bb file
#
# Copyright 2010-2012 by Intel Corp.
#
# Permission is hereby granted, free of charge, to any person obtaining a copy 
# of this software and associated documentation files (the "Software"), to deal 
# in the Software without restriction, including without limitation the rights 
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
# copies of the Software, and to permit persons to whom the Software is 
# furnished to do so, subject to the following conditions:

# The above copyright notice and this permission notice shall be included in 
# all copies or substantial portions of the Software.

# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
# THE SOFTWARE.


SUMMARY = "Application Development Toolkit"
DESCRIPTION = "Creates the Application Development Toolkit (ADT) installer tarball"
HOMEPAGE = "http://www.yoctoproject.org/tools-resources/projects/application-development-toolkit-adt"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
LICENSE = "MIT"

PACKAGES = ""
INHIBIT_DEFAULT_DEPS = "1"

PR = "r11"

ADT_DEPLOY = "${DEPLOY_DIR}/sdk"
ADT_DIR = "${WORKDIR}/adt-installer"
S = "${WORKDIR}/opkg-${PV}"

PV = "0.4.1"
SRC_URI = "http://downloads.yoctoproject.org/releases/opkg/opkg-${PV}.tar.gz \
           file://wget_cache.patch \
           file://adt_installer.sh \
	   file://armtemplate.txt \
	   file://x86template.txt \
	   file://fetch_kits.sh \
	   file://insert.py \
           file://scripts/adt_installer_internal \
           file://scripts/util \
           file://scripts/data_define \
           file://scripts/extract_rootfs \
           file://adt_installer.conf \
	   file://decompress \
           file://opkg/conf/opkg-sdk-x86_64.conf \
           file://opkg/conf/opkg-sdk-i686.conf \
	  "

SRC_URI[md5sum] = "ba0c21305fc93b26e844981ef100dc85"
SRC_URI[sha256sum] = "45ac1e037d3877f635d883f8a555e172883a25d3eeb7986c75890fdd31250a43"

# This recipe makes no sense as a multilib
MULTILIBS = ""

do_populate_adt[umask] = "022"

fakeroot do_populate_adt () {
	cd ${WORKDIR}
	mkdir -p ${ADT_DEPLOY}
	rm -f ${ADT_DEPLOY}/emac_adt_installer
	rm -rf ${ADT_DIR}
	mkdir -p ${ADT_DIR}/opkg/build
	mkdir -p ${WORKDIR}/payload
	cp -r opkg ${ADT_DIR}/
	cp -r opkg-${PV} ${ADT_DIR}/opkg/build/
	mv ${ADT_DIR}/opkg/build/opkg-${PV} ${ADT_DIR}/opkg/build/opkg-svn
	rm -rf ${ADT_DIR}/opkg/build/opkg-svn/patches ${ADT_DIR}/opkg/build/opkg-svn/.pc
	cp -r scripts ${ADT_DIR}/
	cp adt_installer.sh ${ADT_DIR}
	cp adt_installer.conf ${ADT_DIR}
	cp armtemplate.txt ${ADT_DIR}
	cp x86template.txt ${ADT_DIR}
	cp fetch_kits.sh ${ADT_DIR}
	cp insert.py ${ADT_DIR}

	echo 'SDK_VENDOR=${SDK_VENDOR}' >> ${ADT_DIR}/scripts/data_define
	echo 'DEFAULT_INSTALL_FOLDER=${SDKPATH}' >> ${ADT_DIR}/scripts/data_define
	cp ${COREBASE}/scripts/relocate_sdk.py ${ADT_DIR}/scripts/
	tar -czf adt_installer.tar.gz adt-installer
	mv adt_installer.tar.gz payload/
	#begin self extracting tarball code
	OUTFILE=emac_adt_installer
	cd payload
	tar cf ../payload.tar ./* 
	cd ..

	if [ -e "payload.tar" ]; then
    	gzip -f payload.tar

    if [ -e "payload.tar.gz" ]; then
        cat decompress payload.tar.gz > $OUTFILE
        chmod +x $OUTFILE
    else
        echo "payload.tar.gz does not exist"
        exit 1
    fi  
	else
    	echo "payload.tar does not exist"
    	exit 1
	fi
	echo "$OUTFILE was created"
	#end self extracting tarball code
	cp ${WORKDIR}/emac_adt_installer ${ADT_DEPLOY}

}

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_poplulate_sysroot[noexec] = "1"

addtask populate_adt before do_build after do_install

