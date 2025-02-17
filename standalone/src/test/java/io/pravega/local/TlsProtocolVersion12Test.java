/**
 * Copyright Pravega Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.pravega.local;

import io.pravega.test.common.SerializedClassRunner;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.pravega.local.PravegaSanityTests.testWriteAndReadAnEvent;

@RunWith(SerializedClassRunner.class)
public class TlsProtocolVersion12Test {

    @ClassRule
    public static final PravegaEmulatorResource EMULATOR = PravegaEmulatorResource.builder().tlsEnabled(true).tlsProtocolVersion(new String[] {"TLSv1.2"}).build();

    @Test(timeout = 30000)
    public void testTlsProtocolVersiontls1_2() throws Exception {
        testWriteAndReadAnEvent("tls12scope", "tls12stream", "Test message on the TLSv1.2 encrypted channel",
                EMULATOR.getClientConfig());
    }
}
