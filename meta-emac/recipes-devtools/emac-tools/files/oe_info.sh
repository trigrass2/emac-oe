#!/bin/sh

echo
echo "####################################################"
echo "####################################################"
echo
echo "Gathering build information..."
echo

fsPN=$(cat /etc/version | grep "part_number" | cut -d '"' -f2)
oeVers=$(cat /etc/version | grep -m1 "version=" | cut -d '"' -f2)

kernVers=$(uname -r | cut -d '_' -f1)
kernPart=$(uname -r | cut -d '_' -f2 )

if [ -x /usr/sbin/lilo ]; then
        bootVers=$(lilo -V)
else
	mtdNum=$(cat /proc/mtd | grep spi | cut -d ':' -f1)
        boot=$(strings /dev/$mtdNum | grep 'U-Boot [0-9]' -m1 | cut -d '(' -f1)
        bootVers=$(echo $boot | cut -d '_' -f1)
        bootPart=$(echo $boot | cut -d '_' -f2)
        bootStrap=$(strings /dev/$mtdNum | grep 'AT91Boot' -A1 -m1 | cut -d '(' -f1)
        serialNum=$(fw_printenv serial#)
fi

echo "Product: "$(hostname) > /tmp/oe_info
[ -n "$serialNum" ] && echo "Serial Number: "${serialNum:8} >> /tmp/oe_info
echo >> /tmp/oe_info
[ -n "$bootStrap" ] && echo "Bootstrap: "$bootStrap >> /tmp/oe_info
echo >> /tmp/oe_info
echo "Bootloader Part# "$bootPart >> /tmp/oe_info
echo "Bootloader Ver#: "$bootVers >> /tmp/oe_info
echo >> /tmp/oe_info
echo "Kernel Part#: "$kernPart >> /tmp/oe_info
echo "Kernel Ver#: "$kernVers >> /tmp/oe_info
echo >> /tmp/oe_info
echo "Filesystem Part#: "$fsPN >> /tmp/oe_info
echo "Filesystem Ver#: "$oeVers >> /tmp/oe_info

cat /tmp/oe_info
echo
echo "####################################################"
echo "####################################################"

if [ -w / ]; then
        mv /tmp/oe_info /etc/oe_info
fi

echo

