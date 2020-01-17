#!/bin/bash

user=$(whoami)
. scripts/data_define

config_dir=$HOME/.config/QtProject/qtcreator/
identifier="<!-- This comment is for the EMAC ADT parsing script -->"

case $1 in
	1)
		target_sysroot=armv5e;;
	2)
		target_sysroot=armv7a-neon;;
	3)
		target_sysroot=cortexa5-vfp;;
	4)
		target_sysroot=i586;;
	5)
		target_sysroot=core2-32;;
esac

if [[ ! -d "$config_dir" ]]
	then
	mkdir -p $config_dir
	wget $YOCTOADT_REPO/emac_Qt_build/kit.tar.gz
	tar -xzf kit.tar.gz
	python insert.py
	sed -i "s|home_dir|/home/${user}|" kit/qtversion.xml kit/profiles.xml
	sed -i "s|target_sysroot|${target_sysroot}|" kit/profiles.xml
	mv kit/*.xml $config_dir
else
	if grep -Fxq $identifier $config_dir/profiles.xml
		then
		python insert.py $config_dir/profiles.xml
		sed -i "s|home_dir|/home/${user}|" profiles.xml
		sed -i "s|target_sysroot|${target_sysroot}|"
	else
		wget $YOCTOADT_REPO/emac_Qt_build/kit.tar.gz
		tar -xzf kit.tar.gz
		python insert.py kit/profiles.xml
		sed -i "s|home_dir|/home/${user}|" kit/profiles.xml
		sed -i "s|target_sysroot|${target_sysroot}|" kit/profiles.xml
		rm $config_dir/*.xml
		mv kit/*.xml $config_dir
	fi
fi
