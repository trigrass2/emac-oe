#!/bin/sh

usage()
{
	echo
	echo "USAGE:"
	echo -e "\toe_info.sh [option]"
	echo
	echo "OPTIONS:"
	echo -e "\t-c show cpu info"
	echo -e "\t   Display number of CPUs, BogoMIPS, chip arhitecture, CPU utilization, and CPU clock speed"
	echo -e "\t-f flash info"
	echo -e "\t   Shows how much space is used and available on the filesystem and provides a list of \n\t   partitions found int /proc/partitions"
	echo -e "\t-m show memory info"
	echo -e "\t   Display space used and available in main memory"
	echo -e "\t-n network info"
	echo -e "\t-v invoke all options above"
	echo
	echo -e "\t-h display usage and options list"
	echo
}

c_opt()
{
	echo "CPU info"
	echo
	echo $(cat /proc/cpuinfo | grep -i bogomips | head -n1)

	# Determine Architecture
	# This one is rather complicated.
	#
	# If cpuinfo has a segment for hardware,
	# assume ARM architecure and display the
	# hardware line.
	#
	# Else, assume x86. It will either have
	# arhitecture info on vendor id or model
	# name. But both of them have those desriptors...

	ARC=$(cat /proc/cpuinfo | grep -i hardware)
	ARM=$?
	if [[ $ARM = 0 ]]; then
		echo "Architecture: ARM,$(echo $ARC | cut -d ':' -f2 )"
	else
		# x86 architecure, model names located
		# at different locations in /proc/cpuinfo
		VEND=$(cat /proc/cpuinfo | grep -i vendor_id | head -n1 | cut -d ':' -f2)
		if [[ "$(echo $VEND | cut -d ' ' -f1)" = "Vortex86" ]]; then
			echo "Architecture: x86,$VEND"
		else
			echo "Architecture: x86," $(cat /proc/cpuinfo | grep -i "model name" | head -n1 | cut -d ':' -f2)
		fi
	fi

	THREADS=$(cat /proc/cpuinfo | grep -i "cpu cores" | wc -l)
	if [[ $THREADS = 0 ]]; then
		echo "Number of CPUs: "$(cat /proc/cpuinfo | grep "model name" | wc -l) "core(s)"
	else
		echo "Number of CPUs: $(cat /proc/cpuinfo | grep -i "cpu cores" | head -n1 | cut -d ':' -f2) core(s), $THREADS thread(s)"
	fi

	echo "CPU Utilization: " $( top -b -n1 | grep Cpu | awk '{print $2}' | cat ) "%"

	MHZ=$( cat /proc/cpuinfo | grep MHz | head -n1 | awk '{print $4}' | cut -d "." -f1 )
	if [[ -e MHZ ]]; then
		echo "Clock speed: "$MHZ "MHz"
	else
		MHZ=$(dmesg | grep Clocks | awk '{print $3}')
		if [[ -e MHZ ]]; then
			echo "Clock speed: "$MHZ "MHz"
		else
			echo "Clock speed: error reading cpuinfo and dmesg for clock speed"
		fi
	fi
}

f_opt()
{
	echo "Flash Info:"
	echo
	df -h
	echo
	echo "Partitions:"
	cat /proc/partitions
}

m_opt()
{
	echo "Memory Info: "
	echo
	MEM=$(free -h | grep Mem)
	echo "Total: "$(echo $MEM | awk '{print $2}')
	echo "Used:  "$(echo $MEM | awk '{print $3}')
	echo "Free:  "$(echo $MEM | awk '{print $4}')
}

n_opt()
{
	CONNECTED=$(ip address | grep "state UP" | awk '{print $2}' | cut -d ":" -f1)
	echo "Network Info:"
	if [[ $CONNECTED ]]; then
		for SITES in $CONNECTED;
		do
			echo
			echo "Connection at "$SITES
			INFO=$(ifconfig $SITES | grep "inet addr")
			echo "IP address:  "$(echo $INFO | awk '{print $2}' | cut -d ":" -f2)
			echo "Netmask:     "$(echo $INFO | awk '{print $4}' | cut -d ":" -f2)
			echo "Gateway:     "$(route -n | grep UG | awk '{print $2}')
			echo "Hostname:    "$(hostname)
			echo "MAC address: "$(ifconfig $SITES | head -n1 | awk '{print $5}')
		done
	else
	echo "System is not connection to a network."
fi
}


if [[ $# > 0 ]]; then
	while getopts nfmvch OPT; do
		case $OPT in
			c)
				c_opt
				break
				;;
			f)
				f_opt
				break
				;;
			h)
				usage
				break
				;;
			m)
				m_opt
				break
				;;
			n)
				n_opt
				break
				;;
			v)
				c_opt
				echo
				f_opt
				echo
				m_opt
				echo
				n_opt
				break
				;;
			\?)
				echo "See usage and option list below:"
				usage
				break
				;;
		esac
	done
	exit 0
fi

############################################################
################ Default, no options given #################
############################################################

echo
echo "####################################################"
echo "####################################################"
echo
echo "Gathering build information..."
echo

fsPN=$(cat /etc/version | grep "part_number" | cut -d '"' -f2)
oeVers=$(cat /etc/version | grep -m1 "version=" | cut -d '"' -f2)
fsRev=$(cat /etc/version | grep "repository" | cut -d '"' -f2)
fsRev=${fsRev:0:10}

kernVers=$(uname -r | cut -d '_' -f1)
kernPart=$(uname -r | cut -d '_' -f2 | cut -d '+' -f1 )
kernRev=$(uname -r | cut -d '_' -f2 | cut -d '+' -f2 )

#Get carrier model number and look up part number component#
[ -f /proc/device-tree/model ] && carrier=$(cat /proc/device-tree/model | awk -F ' ' '{print($NF)}')
if [ -z "$carrier" ]; then
	carrier=""
fi

carrierNumber=0;
case ${carrier:4:3} in
	150)
		carrierNumber=1;
		;;
	200)
		carrierNumber=2;
		;;
	210)
		carrierNumber=3;
		;;
	212)
		carrierNumber=4;
		;;
	250)
		carrierNumber=5;
		;;
	300)
		carrierNumber=6;
		;;
	320)
		carrierNumber=7;
		;;
	350)
		carrierNumber=8;
		;;
esac
kernPart=${kernPart:0:9}${carrierNumber}${kernPart:10}

#Get info on CPLD for the 150 and 200 carriers
CPLD=$(dmesg | grep 'EMAC core')

if [ -x /usr/sbin/lilo ]; then
        bootVers=$(lilo -V)
elif [ -x /usr/sbin/grub-install ]; then
        bootVers=$(grub-install -v | cut -d ' ' -f3)
        bootVers="GRUB $bootVers"
else
	mtdNum=$(cat /proc/mtd | grep spi | cut -d ':' -f1)
	boot=$(fw_printenv ver | cut -d '=' -f2)
        bootVers=$(echo $boot | cut -d '_' -f1)
        bootPart=$(echo $boot | cut -d '_' -f2 | cut -d '+' -f1)
	bootRev=$(echo $boot | cut -d '_' -f2 | cut -d '+' -f2 | cut -d ' ' -f1)
	soc=$(fw_printenv soc | cut -d '=' -f2)
	if [ $soc = "at91" ]; then
        	bootStrap=$(strings /dev/$mtdNum | grep 'AT91Boot' -m1 | cut -d '(' -f1)
		bootStrapVers=$(echo $bootStrap | cut -d '_' -f1)
		bootStrapPart=$(echo $bootStrap | cut -d '_' -f2 | cut -d '+' -f1)
		bootStrapRev=$(echo $bootStrap | cut -d '_' -f2 | cut -d '+' -f2 | cut -d ' ' -f1)
	else
		bootStrapVers=""
		bootStrapPart=""
		bootStrapRev=""
	fi
        serialNum=$(fw_printenv serial#)
fi

echo "Product: "$(hostname) > /tmp/oe_info
[ -n "$carrier" ] && echo "Carrier:" $carrier >> /tmp/oe_info
[ -n "$serialNum" ] && echo "Serial Number: "${serialNum:8} >> /tmp/oe_info
echo >> /tmp/oe_info
if [ -n "$bootStrap" ];then
	echo "Bootstrap Part#: "$bootStrapPart >> /tmp/oe_info
	echo "Bootstrap Ver#: "$bootStrapVers >> /tmp/oe_info
	echo "Bootstrap Rev#: "$bootStrapRev >> /tmp/oe_info
fi
echo >> /tmp/oe_info
echo "Bootloader Part# "$bootPart >> /tmp/oe_info
echo "Bootloader Ver#: "$bootVers >> /tmp/oe_info
echo "Bootloader Rev: "$bootRev >> /tmp/oe_info
echo >> /tmp/oe_info
echo "Kernel Part#: "$kernPart >> /tmp/oe_info
echo "Kernel Ver#: "$kernVers >> /tmp/oe_info
echo "Kernel Rev: "$kernRev >> /tmp/oe_info
echo >> /tmp/oe_info
echo "Filesystem Part#: "$fsPN >> /tmp/oe_info
echo "Filesystem Ver#: "$oeVers >> /tmp/oe_info
echo "Filesystem Rev: "$fsRev >> /tmp/oe_info
if [ ! -z "$CPLD" ]; then
	echo >> /tmp/oe_info
	echo "CPLD: "$CPLD >> /tmp/oe_info
fi

cat /tmp/oe_info
echo
echo "####################################################"
echo "####################################################"

if [ -w / ]; then
        mv /tmp/oe_info /etc/oe_info
	/usr/bin/webwriter.sh
fi

echo
