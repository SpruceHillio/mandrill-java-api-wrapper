/*
Copyright 2013-2014 SpruceHill.io GmbH

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

package io.sprucehill.mandrill.service;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sprucehill.mandrill.data.request.AbstractPayload;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public abstract class AbstractService {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected String baseUrl = "https://mandrillapp.com/api/1.0";

    protected JerseyClient jerseyClient;

    protected String key;

    /**
     * @param baseUrl
     */
    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * @param jerseyClient
     */
    public void setClient(final JerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    /**
     * @param key
     */
    public void setKey(final String key) {
        this.key = key;
    }

    @PostConstruct
    public final void postConstruct() {
        onPostConstruct();
    }

    void onPostConstruct() {
        if (null == jerseyClient) {
            jerseyClient = JerseyClientBuilder.createClient();
        }
    }

    <T extends AbstractPayload.Init<T, U>, U extends AbstractPayload> void integrateDefaultValues(AbstractPayload.Init<T, U> payloadBuilder) {
        if (!payloadBuilder.hasKey() && null != key && !key.isEmpty()) {
            payloadBuilder.withKey(key);
        }
    }

    <T, E extends Error> T send(final AbstractPayload payload, final Class<T> responseClass,
                                final Class<E> errorClass) throws E, IOException {
        final Response response = jerseyClient
                .target(baseUrl)
                .path(payload.getPath())
                .request()
                .post(Entity.json(payload));

        if (200 == response.getStatus()) {
            final T result = response.readEntity(responseClass);
            return result;
        } else {
            final E error = response.readEntity(errorClass);
            LOGGER.debug("Got error {} while calling {}.", error.toString(), payload.getPath());
            throw error;
        }
    }
}
