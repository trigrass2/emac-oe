#!/bin/bash
# Yocto ADT Installer
#
# Copyright 2010-2011 by Intel Corp.
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


usage ()
{

  INST_ARCH=`uname -m`
  INST_OS=`uname -o| tr '[A-Z]' '[a-z]'`
  INST_KR=`uname -r| tr '[A-Z]' '[a-z]'`

  echo_info "#########################################################################"
  echo_info "# Welcome to EMAC Application Developement Tools (ADT) Installer"
  echo_info "# "
  echo_info "# Host Machine:\t\t\t\t"$INST_ARCH
  echo_info "# OS info:\t\t\t\t$INST_KR"
  echo_info "# EMAC ADT version to be installed:\t$YOCTOADT_VERSION"
  echo_info "# supported target architectures:\t$YOCTOADT_SUPPORTED_TARGETS"
  echo_info "# supported target root_fs images:\t$YOCTOADT_SUPPORTED_ROOTFS"
  echo_info "#########################################################################\n"

  echo_info "Systemwide installation. Installation will occur under $INSTALL_FOLDER\n"
  echo_info "############################################################################"
  echo_info "# Your system installation configurations from adt_installer.conf"
  echo_info "############################################################################"

  echo_info "# Cross toolchains:\t\t$YOCTOADT_TARGETS"
  echo_info "# Install Qemu:\t\t\t$YOCTOADT_QEMU"
  echo_info "# Install NFS utilities:\t$YOCTOADT_NFS_UTIL"
  #echo_info "# Install bitbake + UI:\t\t$YOCTOADT_BITBAKE"
  #echo_info "# Install metadata:\t$YOCTOADT_METADATA"
  #echo_info "############################################################################\n"

    echo_info "\n##############################################################################"
    echo_info "# Your rootfs image(s) and target sysroot selections from adt_installer.conf"
    echo_info "##############################################################################"
prompt=1
  download_images $YOCTOADT_TARGETS $prompt

    echo_info "############################################################################\n"
  select_install_type
}

validate_config()
{
    found=0
    select_machine_var="\$YOCTOADT_TARGET_MACHINE_$YOCTOADT_TARGETS"
    select_machine=`eval echo $select_machine_var`
    show_error_banner=0

    for supported_arch_type in $YOCTOADT_SUPPORTED_TARGETS; do
      if [ "$YOCTOADT_TARGETS" == "$supported_arch_type" ]; then
        found=1
        break
      fi
    done
    if [ $found == 0 ]; then
       echo_info "[ADT_INST] Error: YOCTADT_TARGETS in adt_installer.conf contains invalid entries: $YOCTOADT_TARGETS. Valid values are: $YOCTOADT_SUPPORTED_TARGETS"
       show_error_banner=1
    elif [ -z "$select_machine" ]; then
       echo_info "[ADT_INST] Error: No MACHINE was defined for $selected_arch_type architecture! This is needed to install the toolchain and the correct environment settings."
       echo_info "[ADT_INST] To do that, in adt-installer.conf, set the following variable: YOCTOADT_TARGET_MACHINE_$selected_arch_type"
       show_error_banner=1
    fi

    if [ $show_error_banner == 1 ]; then
       echo -e "\n#############################################################################"
       echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
       echo -e "#############################################################################\n"
       exit -1
    fi
  

  for arch_type in $YOCTOADT_SUPPORTED_TARGETS; do
    #select_target_var="\$YOCTOADT_TARGET_$arch_type"
    #select_target=`eval echo $select_target_var`

    #if [ "$select_target" != "Y" ] || [ "$selected_target" != "y" ]; then
    #  continue;
    #fi

    target_sysroot_image_var="\$YOCTOADT_TARGET_SYSROOT_IMAGE_$arch_type"
    target_sysroot_image=`eval echo $target_sysroot_image_var`


    select_rootfs_var="\$YOCTOADT_ROOTFS_$arch_type"
    select_rootfs=`eval echo $select_rootfs_var`

    if [ "$select_rootfs" == "" ] && [ "$target_sysroot_image" == "" ]; then
       continue;
    fi

    for image_type in $select_rootfs; do
#validate rootfs type defined in YOCTOADT_ROOTFS_{ARCH} is valid and in YOCTOADT_SUPPORTED_ROOTFS
      found=0
      for supported_rootfs_type in $YOCTOADT_SUPPORTED_ROOTFS; do
        if [ "$image_type" == "$supported_rootfs_type" ]; then
          found=1
          break
        fi
      done
      if [ $found == 0 ]; then
#the rootfs type listed for downloading is not valid
        echo_info "[ADT_INST] Error: Selected YOCTOADT_ROOTFS_$arch_type value: $image_type, is not valid! Valid values are: $YOCTOADT_SUPPORTED_ROOTFS "
       echo -e "\n#############################################################################"
       echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
       echo -e "#############################################################################\n"
        exit -1
      fi
    done

    found=0
    for image_type in $select_rootfs; do
#validate that rootfs to be extracted must be in the item: YOCTOADT_ROOTFS_${ARCH}
      if [ "$target_sysroot_image" == "$image_type" ]; then
        found=1
        break
      fi
    done
# the rootfs image to be extracted is not selected
    if [ $found == 0 ]; then
      echo_info "[ADT_INST] Error: YOCTOADT_TARGET_SYSROOT_IMAGE_$arch_type selection: $target_sysroot_image is not included in YOCTOADT_ROOTFS_$arch_type selections: $select_rootfs"
      echo -e "\n#############################################################################"
      echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
      echo -e "#############################################################################\n"
      exit -1
    fi
  done
}


#detect opkg installed or not, for installing sdk, we will use
#this installed local opkg
install_opkg()
{
if [ ! -x "$LOCAL_OPKG_LOC/bin/opkg" ]; then
  echo_info "OPKG is not setup, setting up opkg in local, which is required for installing EMAC ADT...\n"

  if [ -d $LOCAL_OPKG_LOC ]; then
    echo_info "Deleting old OPKG folder, which doesn't contain executables... "
    rm -rf $LOCAL_OPKG_LOC
  fi

  parent_folder=`pwd`
  cd $LOCAL_OPKG_FOLDER
  check_result

  opkg_source_dir=`ls -d opkg-*`

  if [ $opkg_source_dir == "" ]; then
    echo_info "[ADT_INST] Error: OPKG source directory is not found!"
    echo -e "\n#############################################################################"
    echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
    echo -e "#############################################################################\n"
    exit -1
  fi

  cd $opkg_source_dir
  check_result

  echo_info "Configure opkg ...\n"
  autoreconf -if
  ./configure --prefix=$parent_folder/$LOCAL_OPKG_LOC --enable-shared=no --disable-curl --disable-ssl-curl --disable-gpg >> $parent_folder/$YOCTOADT_INSTALL_LOG_FILE
  check_result

  echo_info "Make opkg ...\n"
  make &>> $parent_folder/$YOCTOADT_INSTALL_LOG_FILE
  check_result

  echo_info "Make Install opkg ...\n"
  make install &>> $parent_folder/$YOCTOADT_INSTALL_LOG_FILE
  #if meet error when installing opkg, cancel the installation
  check_result

  cd $parent_folder
  echo_info "Successfully installed OPKG.\n"
fi
}

confirm_download()
{
#avoid repeated reminding
if [ "$override_oldfile" == 1 ]; then
  return $pre_result
else
  override_oldfile=1
fi

while true; do
  #echo_info "[ADT_INST] Files [$1] already exists. If you continue downloading, old files will be overrided."
  #echo_info "[ADT_INST] Further prompts will not be given if there're more existing files to be downloaded."
  #echo_info "[ADT_INST] Do you want to continue downloading? Please enter Y/N:"
  echo_info "\nFile [$1] already exists, which means you've downloaded the qemu kernel and rootfs file(s) before.  If you choose continue downloading, old files will be overridden."
  echo_info "[ADT_INST] Do you want to continue downloading? Please enter Y/N:"
  read YOCTOADT_INSTALL
  YOCTOADT_INSTALL=`tr '[a-z]' '[A-Z]'<<<"$YOCTOADT_INSTALL"`
  if [ "$YOCTOADT_INSTALL" == "Y" ]; then
    pre_result=0
    return 0
  elif [ "$YOCTOADT_INSTALL" == "N" ]; then
    pre_result=1
    return 1
  fi
done
}

download_file()
{
local filename=`echo ${1##*/}`
if [ -f "$LOCAL_DOWNLOAD/$filename" ]; then
  confirm_download $filename
  result="$?"
  if [ ! "$result" == "0" ]; then
    return
  else
    echo "Removing old file [$1]"
    rm -rf "$LOCAL_DOWNLOAD/$filename" 
  fi
fi
echo_info "Downloading file: $filename..."
wget "$YOCTOADT_REPO/rootfs/$1" -P $LOCAL_DOWNLOAD --progress=bar:force 2>&1 | tee -a "$YOCTOADT_INSTALL_LOG_FILE" 
}



#Need three input params:
# $1 arch_type(arm powerpc x86 mips)
# $2 machine(qemuarm beagleboard)
# $3 rootfs_image_type (a list of sdk sato minimal lsb)
get_image()
{
  local machine=$2
 
  #if [ "$1" == "x86" ] || [ "$1" == "x86_64" ]; then
  #  kernel="bzImage-$machine.bin"
  #elif [ "$1" == "ppc" ] || [ "$1" == "mips" ]; then
  #  kernel="vmlinux-$machine.bin"
  #else
  #  kernel="zImage-$machine.bin"
  #fi

  #echo_info "[ADT_INST] Downloading qemu kernel binary: $qemu_kernel"
  #download_file $machine/$kernel
  #check_result
  
    #for image_type in $select_rootfs; do
	echo_info "[ADT_INST] Downloading rootfs file: $machine-rootfs.tar.gz"
	#echo_info "[ADT_INST] Downloading rootfs file: $machine-rootfs.tar-dbg.gz"
    #filename="core-image-$image_type-$machine.tar.bz2"
    filename="$machine-rootfs.tar.gz"
	#filename_dbg="$machine-rootfs-dbg.tar.gz"
    download_file $filename
	#download_file $filename_dbg
	
    check_result
  #done
}

download_images()
{
  select_rootfs_var="\$YOCTOADT_ROOTFS_$1"
  select_sysroot_image_var="\$YOCTOADT_TARGET_SYSROOT_IMAGE_$1"
  select_sysroot_var="\$YOCTOADT_TARGET_SYSROOT_LOC_$1"
  select_machine_var="\$YOCTOADT_TARGET_MACHINE_$1"
  select_rootfs=`eval echo $select_rootfs_var`
  select_sysroot_image=`eval echo $select_sysroot_image_var`
  select_sysroot=`eval echo $select_sysroot_var`
  select_machine=`eval echo $select_machine_var`

  if [ -n "$select_sysroot" ]; then
    select_sysroot=`readlink -m $select_sysroot`
  fi

  #if [ "$select_rootfs" != "" ]; then
    if [ $2 ]; then
    #echo_info "\n############################################################################"
    #echo_info "# To be downloaded rootfs image details defined in adt_installer.conf"
    #echo_info "############################################################################"
    echo_info "# Target architecture:\t\t$1"
    echo_info "# Target machine:\t\t$select_machine"
    echo_info "# Root_fs images:\t\t$select_rootfs"
    echo_info "# Target sysroot image:\t\t$select_sysroot_image"
    echo_info "# Target sysroot loc:\t\t$select_sysroot"
    echo_info "\n"
    #echo_info "############################################################################\n"
    else
    get_image $1 $select_machine $select_rootfs
    fi
  #fi
}

install_deps()
{
	#installs distro-specific dependencies for the ADT installer
	DISTRO=$( cat /etc/*release* | grep ^NAME | cut -d '=' -f 2  )

	echo
	echo "##########################################################################"
	echo "       Installing dependencies for detected distrobution: $DISTRO"
	echo "##########################################################################"
	echo
	echo "WARNING: Sudo must be installed and user must be in Sudo group to continue"

    case $DISTRO in
        #documentation for all distros can be found at:
        #http://www.yoctoproject.org/docs/2.0/ref-manual/ref-manual.html#required-packages-for-the-host-development-system
        *Ubuntu* | *Debian*)
	sudo apt-get install cmake gawk wget git-core diffstat unzip texinfo python gcc-multilib build-essential chrpath socat autoconf automake libtool libglib2.0-dev libarchive-dev sshpass;;
        Fedora)
            sudo dnf install cmake gawk make wget tar bzip2 gzip python unzip perl patch diffutils diffstat git cpp gcc gcc-c++ glibc-devel texinfo chrpath ccache perl-Data-Dumper perl-Text-ParseWords perl-Thread-Queue socat findutils which autoconf automake libtool glib2-devel libarchive-devel sshpass;;
        *openSUSE*)
            sudo zypper install cmake python gcc gcc-c++ git chrpath make wget python-xml diffstat makeinfo python-curses patch socat autoconf automake libtool glib2-devel libarchive-devel sshpass;;
        *CentOS*)
            sudo yum install cmake gawk make wget tar bzip2 gzip python unzip perl patch diffutils diffstat git cpp gcc gcc-c++ glibc-devel texinfo chrpath socat perl-Data-Dumper perl-Text-ParseWords perl-Thread-Queue autoconf automake libtool glib2-devel libarchive-devel sshpass;;

        *)
                	echo "Distrobution not supported.";;
	esac
}

fetch_kit()
{
	user=$(whoami)
	config_dir=$HOME/.config/QtProject/qtcreator/

	case $1 in
		1)
			target_sysroot=armv5e
			pass_arch=arm;;
		2)
			target_sysroot=i586
			pass_arch=i586;;
	esac

	if [[ ! -d "$config_dir" ]]
		then
		mkdir -p $config_dir
		wget $YOCTOADT_REPO/../emac_Qt_build/kit.tar.gz
		tar -xzf kit.tar.gz
		rm kit.tar.gz
		mv kit/* .
		rm -rf kit/
		python insert.py $pass_arch 1
		sed -i "s|home_dir|/home/${user}|" qtversion.xml profiles.xml
		sed -i "s|target_sysroot|${target_sysroot}|" profiles.xml
		sed -i "s|insert_num|1|" profiles.xml
		mv *.xml $config_dir
	else
		check=$(grep $pass_arch ${config_dir}/profiles.xml)
		if [[ -z $check ]]
			then
			num=$(grep "<variable>Profile..</variable>" $config_dir/profiles.xml | wc -l)
			mv $config_dir/profiles.xml . 
			python insert.py $pass_arch $num
			sed -i "s|home_dir|/home/${user}|" profiles.xml
			sed -i "s|target_sysroot|${target_sysroot}|" profiles.xml
		    	sed -i "s|insert_num|${num}|" profiles.xml
			updateLine=$(grep -n Profile.Count profiles.xml | cut -d ":" -f1)
			updateCount='<value type="int">'$((num + 1))'</value>'
			sed -i "$((updateLine + 1))s|.*|$updateCount|" profiles.xml 
			mv profiles.xml $config_dir
		fi
	fi
}

fetch_examples()
{
	#fetches Qt example projects and places them in the ~/EMAC-SDK directory
	if [[ ! -d "$HOME/EMAC-SDK/example-projects" ]]
		then
			echo
			echo "##################################################"
			echo "              Fetching Qt Exmaples                "
			echo "##################################################"
			echo
		 
			wget http://git.emacinc.com/OE/qt-creator-example-projects/repository/archive.tar.gz
			tar -xzf archive.tar.gz
			rm archive.tar.gz
			mv qt* example-projects
			mv example-projects/ ~/EMAC-SDK/
	fi

	if [[ ! -d "$HOME/EMAC-SDK/emac-QtCreator" ]]
		#installs Qt Creator if user says yes
		then
			echo
			read -p "Would you like to install Qt Creator? [y/N]?" PROMPT
			echo

			case $PROMPT in 
				y|Y)
					QtBuild="emac-QtCreator"
					wget $YOCTOADT_REPO/../emac_Qt_build/$QtBuild.tar.gz
					tar -xzf $QtBuild.tar.gz
					rm $QtBuild.tar.gz
					mv $QtBuild/ ~/EMAC-SDK/
					wget $YOCTOADT_REPO/../emac_Qt_build/EMAC.png
					sudo mv EMAC.png /opt/emac/${SDK_VERSION}/share/;;
				*);;
			esac 
	fi

	if [[ -d "$HOME/EMAC-SDK/emac-QtCreator" ]]
	then
		#installs Qt Creator kits based on which ones are needed
		fetch_kit $1
	fi

	if [[ ! -f "$HOME/Desktop/emacqt.desktop" && ($PROMPT = 'y' || $PROMPT = 'Y') ]]
	#puts Qt Creator icon on desktop if user says yes
	then
		echo
		read -p "Would you like to place the EMAC Qt Creator icon on the desktop? [y/N]" PROMPT
		echo

		case $PROMPT in
			y|Y)
				user=$(whoami)
				wget $YOCTOADT_REPO/../emac_Qt_build/emacqt.desktop
			    	sed -i "s|USERNAME|${user}|" emacqt.desktop
			    	mv emacqt.desktop ~/.local/share/applications/
			    	chmod +x ~/.local/share/applications/emacqt.desktop
			    	ln -sf ~/.local/share/applications/emacqt.desktop ~/Desktop/emacqt.desktop
				gio set ~/Desktop/emacqt.desktop "metadata::trusted" yes;;
				*);;
		esac
	fi   		
}

create_symlink() {
	sysroot_dir=$HOME/EMAC-SDK/sysroots
	symlink_dir=/opt/emac/${SDK_VERSION}/sysroots/x86_64-emacsdk-linux/usr/mkspecs
	path=usr/share/qtopia/mkspecs/
	if [[ -d "$sysroot_dir/armv5e" ]]
		then
		mkspecs_dir=$sysroot_dir/armv5e/$path
	elif [[ -d "$sysroot_dir/i586" ]]
		then 
		mkspecs_dir=$sysroot_dir/i586/$path
	elif [[ -d "$sysroot_dir/armv7a-neon" ]]
		then
		mkspecs_dir=$sysroot_dir/armv7a-neon/$path
	elif [[ -d "$sysroot_dir/core2-32" ]]
		then
		mkspecs_dir=$sysroot_dir/core2-32/$path
	elif [[ -d "$sysroot_dir/cortexa5-vfp" ]]
		then
		mkspecs_dir=$sysroot_dir/cortexa5-vfp/$path
	else
		error_flag=1
	fi

	if [[ $error_flag == 1 ]]
		then
		echo
		echo "ERROR: ~/EMAC-SDK/sysroots not found. Exitting installation."
		echo
		exit 0
	else
		sudo ln -s $mkspecs_dir $symlink_dir
	fi
}

#Main body of installer

clear

run_path=`dirname $0`
cd $run_path

if [ ! -f "scripts/util" ]; then
  echo -e "[ADT_INST] Error: Script file: util, can't be found under: $run_path!"
  echo -e "\n#############################################################################"
  echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
  echo -e "#############################################################################\n"
  exit -1
fi

if [ ! -f "scripts/adt_installer_internal" ]; then
  echo -e "[ADT_INST] Error: Script file: adt_installer_internal, can't be found under: $run_path!"
  echo -e "\n#############################################################################"
  echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
  echo -e "#############################################################################\n"
  exit -1
fi

config_file="adt_installer.conf"
if [ ! -f "$config_file" ]; then
  echo_info "[ADT_INST] Error: Installation configuration file: adt_installer.conf is not found!\n"
  echo_info "\n##################################################################################"
  echo_info "# Meet error(s) when installing EMAC ADT. Please check log file for details. "
  echo_info "##################################################################################\n"
  exit -1
fi

install_deps

. scripts/data_define
. scripts/util


if [ -f "$YOCTOADT_INSTALL_LOG_FILE" ]; then
  rm $YOCTOADT_INSTALL_LOG_FILE
fi

clear
INSTALL_FOLDER=$DEFAULT_INSTALL_FOLDER
echo "Install location: $DEFAULT_INSTALL_FOLDER"


eval INSTALL_FOLDER=$(printf "%q" "$INSTALL_FOLDER")
if [ -d "$INSTALL_FOLDER" ]; then
	export INSTALL_FOLDER=$(cd "$INSTALL_FOLDER"; pwd)
else
	export INSTALL_FOLDER=$(readlink -m "$INSTALL_FOLDER")
fi

if [ -n "$(echo $INSTALL_FOLDER|grep ' ')" ]; then
       echo "The target directory path ($INSTALL_FOLDER) contains spaces. Abort!"
       exit 1
fi

echo "Please enter the target architecture."
echo "1. Arm"
echo "2. x86"
echo -n "board: "
read IMAGE_NUMBER

YOCTOADT_TARGETS=""

case $IMAGE_NUMBER in
	#arm
	'1')
		YOCTOADT_TARGETS="armv5e"
		;;
	'2')
		YOCTOADT_TARGETS="i586"
		;;
esac



if [ "$YOCTOADT_TARGETS" = "" ]; then
	echo -e "[ADT_INST] Error: Bad choice in image number given: $IMAGE_NUMBER"
	echo -e "\n#############################################################################"
	echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
	echo -e "#############################################################################\n"
	exit -1
fi

clear

usage

user_inst_type="$?"

validate_config
check_result

#check adt_repo exist
wget --spider $YOCTOADT_REPO 2>&1 | tee -a "$YOCTOADT_INSTALL_LOG_FILE"
if grep -q "404 Not Found" $YOCTOADT_INSTALL_LOG_FILE; then
  echo -e "[ADT_INST] Error: YOCTOADT_REPO does not exist: $YOCTOADT_REPO"
  echo -e "\n#############################################################################"
  echo -e "# Meet error(s) when installing EMAC ADT! Please check log file for details. "
  echo -e "#############################################################################\n"
  exit -1
fi

#firstly we need to install opkg host
install_opkg

#Create folders for holding rootfs/qemu images
if [ ! -d "$LOCAL_DOWNLOAD" ]; then
  echo_info "Creating new images downloading folder: $LOCAL_DOWNLOAD ..."
  mkdir -p $LOCAL_DOWNLOAD
fi

#downloading required qemu images/rootfs
if [ "$user_inst_type" == "0" ]; then
  override_oldfile=1
else
  override_oldfile=0
fi

download_images $YOCTOADT_TARGETS

scripts/adt_installer_internal $user_inst_type $YOCTOADT_TARGETS $select_machine
if [ $? -ne 0 ]; then
  exit 1
fi
fetch_examples $IMAGE_NUMBER

symlink_dir=/opt/emac/${SDK_VERSION}/sysroots/x86_64-emacsdk-linux/usr/mkspecs
if [[ ! -h "$symlink_dir" ]]	
	then
	create_symlink
fi

result="$?"
#echo_info "\n############################################################"
if [ "$result" == "0" ]; then
  echo_info "\n############################################################"
  echo_info "# EMAC ADT has been successfully installed."
  echo_info "############################################################\n"
fi

exit
