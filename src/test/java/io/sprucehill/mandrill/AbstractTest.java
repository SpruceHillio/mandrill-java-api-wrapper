package io.sprucehill.mandrill;

import org.junit.Before;

import io.sprucehill.mandrill.service.AbstractService;

/**
 * Abstract test providing apiKey.
 */
public abstract class AbstractTest {
    protected String apiKey = null;

    @Before
    public void init() {
        // 1. try
        apiKey = System.getenv("mandrill.apikey");

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
        AbstractService.setKey(apiKey);
    }
}
