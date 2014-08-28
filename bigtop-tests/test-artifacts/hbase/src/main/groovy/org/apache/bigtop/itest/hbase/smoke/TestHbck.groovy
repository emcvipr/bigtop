/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.bigtop.itest.hbase.smoke

import org.junit.Test
import org.apache.bigtop.itest.shell.Shell
import static org.junit.Assert.assertTrue
import static org.apache.bigtop.itest.LogErrorsUtils.logError

/**
 * Validates the HBase cluster health.
 */
public class TestHbck {
  //VIPR Fix to run the test under hbase account
  //static Shell sh = new Shell("/bin/bash -s")
  static Shell sh = new Shell("/bin/bash -s","hbase")
  String[] hbckCmds = [
    "hbase hbck",
    "hbase hbck -details",
    "hbase hbck -timelag 120",
    "hbase hbck -summary",
    "hbase hbck -metaonly"
  ]

  @Test
  public void testHbck() {
    for (cmd in hbckCmds) {
      sh.exec(cmd)
      logError(sh)
      assertTrue(sh.getRet() == 0)
    }
  }

}
