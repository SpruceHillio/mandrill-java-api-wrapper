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
        apikey = System.getenv("mandrill.apikey");
        if (apikey == null) {
            throw new IllegalArgumentException("No apikey in environment");
        }
        AbstractService.setKey(apikey);
    }
}
