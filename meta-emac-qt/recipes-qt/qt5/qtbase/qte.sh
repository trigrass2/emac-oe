#!/bin/sh
export QT_QPA_PLATFORM=linuxfb
export QT_QPA_FONTDIR=/usr/share/fonts/ttf
export QT_QPA_GENERIC_PLUGINS=tslib:/dev/input/touchscreen0
export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS='rotate=270'
export QT_QPA_FB_DRM=1
