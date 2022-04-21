require recipes-core/images/emac-minimal-image.bb

DESCRIPTION = "Headless development image from which other EMAC images will be extended."

IMAGE_INSTALL_append = " \
    packagegroup-emac-extras \
"

QB_OPT_APPEND = "-nographic"
QB_MEM = "-m 128"
QB_DEFAULT_FSTYPE = "ext4"

# Add boot patterns to use with OE testimage infrastructure with the serial console
TESTIMAGE_BOOT_PATTERNS = "search_reached_prompt send_login_user search_login_succeeded search_cmd_finished"

# Look for Blocked... to check when the device has booted and its ready to receive an input
TESTIMAGE_BOOT_PATTERNS[search_reached_prompt] ?= "Copyright (C) 2022, EMAC Inc.  All rights reserved."
# Use carriage return as the user to "log in"
# TESTIMAGE_BOOT_PATTERNS[send_login_user] ?= "emac_in"

# Use the string You entered to check if the "log in" was successful (which is what would be printed afterwards)
#TESTIMAGE_BOOT_PATTERNS[search_login_succeeded] ?= "You entered"

# Use the string Unblocked to check if the "command" finished, in the Linux case this should look for a prompt
# In our case, this checks if the task has been Unblocked which is printed on the serial console after a command
#TESTIMAGE_BOOT_PATTERNS[search_cmd_finished] ?= "Unblocked"

## Python local code
TEST_SUITES ?= "emac_echo"
