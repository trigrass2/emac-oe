#!/bin/sh

TS_REMOUNT=false

if [ ! -z $TSLIB_TSDEVICE ] && [ -e $TSLIB_TSDEVICE ] && [ -x /usr/bin/ts_calibrate ]; then
        if [ ! -w / ]; then
                mount -o remount,rw /
                TS_REMOUNT=true
        fi

        /usr/bin/ts_calibrate &
        pid=`pidof ts_calibrate`

        for i in `seq 0 1 10`
        do
                [ ! -d /proc/$pid ] && pid="" && break
                sleep 1
        done

        if [ ! -z $pid ]; then
                kill $pid
        fi

        if [ "$TS_REMOUNT" = true ]; then 
                mount -o remount,ro / 
        fi
fi
