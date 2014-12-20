/*
Copyright 2013-2014 SpruceHill.io GmbH 2014 Stephan Wienczny

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package io.sprucehill.mandrill;

import org.junit.Before;

import io.sprucehill.mandrill.service.MandrillServiceFactory;

/**
 * Abstract test providing apiKey.
 *
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public abstract class AbstractTest {
    protected MandrillServiceFactory mandrillServiceFactory = null;

    @Before
    public void init() {
        // 1. try
        String apiKey = System.getenv("mandrill.apikey");

        // 2. try
        if (apiKey == null || apiKey.isEmpty()) {
            apiKey = System.getenv("mandrill_apikey");
        }

        // 3. try
        if (apiKey == null || apiKey.isEmpty()) {
            apiKey = System.getProperty("mandrill.apikey");
        }

        // 4. try
        if (apiKey == null || apiKey.isEmpty()) {
            apiKey = System.getProperty("mandrill_apikey");
        }

        // failed?
        if (apiKey == null) {
            throw new IllegalArgumentException("No apiKey in environment");
        }

        mandrillServiceFactory = new MandrillServiceFactory(apiKey);
    }
}
