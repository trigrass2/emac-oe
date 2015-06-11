#!/bin/sh

case $1 in
start)
    export TSLIB_TSDEVICE="/dev/input/touchscreen0"
    # set timeout in seconds
    timeout=5

    [ -f /etc/pointercal ] && exit 0

    echo "Touch the screen to begin calibration..." > /dev/tty1

    /usr/bin/touch_detect $timeout

    # Check return value of touch_detect. 2 = touch detected, 0 = timeout, 
    # 1 = error detected
    if [ $? -eq 2 ]
    then
        mount -o remount,rw / >/dev/null
        ts_calibrate
        sync
        # this remount should default to the ro/rw setting from fstab
        mount -o remount /
    else
        echo "Continuing." > /dev/tty1
    fi
    ;;
esac
exit 0
