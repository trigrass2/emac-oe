#!/bin/sh

TS_REMOUNT=false

if [ ! -z $TSLIB_TSDEVICE ] && [ -e $TSLIB_TSDEVICE ] && [ -x /usr/bin/ts_calibrate ]; then
	if [ ! -w / ]; then
		mount -o remount,rw /
		TS_REMOUNT=true
	fi

	/usr/bin/ts_calibrate

        if [ "$TS_REMOUNT" = true ]; then 
                mount -o remount,ro / 
        fi
fi
