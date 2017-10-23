/*
 * Copyright (c) 2008-2017 the original author or authors.
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
package org.cometd.javascript;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * A base test class to be extended for tests valid for any transport.
 */
@RunWith(Parameterized.class)
public abstract class AbstractCometDTransportsTest extends AbstractCometDTest {
    @Parameterized.Parameters(name = "{0}")
    public static String[] transports() {
        return new String[]{"long-polling", "websocket"};
    }

    @Parameterized.Parameter
    public String transport;

    @Override
    protected void initPage() throws Exception {
        super.initPage();
        evaluateScript("only_" + transport, "" +
                "cometd.unregisterTransports();" +
                "cometd.registerTransport('" + transport + "', originalTransports['" + transport + "']);");
    }
}