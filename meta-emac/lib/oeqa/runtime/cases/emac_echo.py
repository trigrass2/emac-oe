 
#
# SPDX-License-Identifier: MIT
#

from subprocess import Popen, PIPE

from oeqa.runtime.case import OERuntimeTestCase
from oeqa.core.decorator.oetimeout import OETimeout
import re

class EmacTest(OERuntimeTestCase):

    @OETimeout(15)
    def test_emac_echo(self):
        # Use a special character with a known behavior
        cmd = 'hello'
        # Send it raw, so it does not look for echo $?, it just looks at the output
        status, output = self.target.runner.run_serial(cmd,raw=True)
        match = bool(re.search(cmd,output))
        self.assertEqual(match, True)
