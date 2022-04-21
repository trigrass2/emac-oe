#
# SPDX-License-Identifier: MIT
#

from subprocess import Popen, PIPE

from oeqa.runtime.case import OERuntimeTestCase
from oeqa.core.decorator.oetimeout import OETimeout
import re

class EmacTest(OERuntimeTestCase):

    @OETimeout(15)
    def test_emac_periodic(self):
        # Send empty string which allows us to read the output of serial console
        cmd = ''
        # Look for Periodic task which runs every 10 seconds, so there
        # should be one printed on the serial console since the timeout is 15
        systemdGood = 'Welcome to EMAC OpenEmbedded Linux 6.0.0!'
        login = '[  OK  ] Reached target Login Prompts.'
        # Send it raw, so it does not look for echo $?, it just looks at the output

        # The following statement needs to be True:
        # 10 secs < run_serial timeout < test timeout
        # This will cause the run_serial function to return before the test times out,
        # but it will have run long enough for the pattern to be found in its output.
        status, output = self.target.runner.run_serial(cmd,raw=True, timeout=12)
        match = bool( re.search( systemdGood, output ) )
        self.assertEqual(match, True) 
