SUMMARY = "PWM tool"
DESCRIPTION = "A tool for enabling and setting the parameters of a pwm output using the sysfs interface"
SECTION = "testing" 
LICENSE = "MIT" 
PR = "r0" 

SRCREV = "45375eee5e6aa2bfba348bcfff803070380b2e00"

SRC_URI = "\
    git://git.emacinc.com/OE/applications/pwm-tools.git;protocol=http;branch=main; \
"

S = "${WORKDIR}/git"

inherit cmake
