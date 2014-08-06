package io.sprucehill.mandrill;

import org.junit.Before;

import io.sprucehill.mandrill.service.AbstractService;

/**
 * Created by stephan on 06.08.14.
 */
public abstract class AbstractTest {
    protected String apikey = null;

    @Before
    public void init() {
        // 1. try
        apikey = System.getenv("mandrill.apikey");

        // 2. try
        if (apikey == null) {
            apikey = System.getenv("mandrill_apikey");
        }

        // failed?
        if (apikey == null) {
            throw new IllegalArgumentException("No apikey in environment");
        }
        AbstractService.setKey(apikey);
    }
}
