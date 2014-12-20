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

package io.sprucehill.mandrill.service;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sprucehill.mandrill.data.request.AbstractPayload;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public abstract class AbstractService {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String baseUrl = "https://mandrillapp.com/api/1.0";

    private JerseyClient jerseyClient;

    private String key;

    /**
     * @param baseUrl set by {@link io.sprucehill.mandrill.service.ServiceFactory} or by user
     */
    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * @return base url currently set
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @param jerseyClient set by {@link io.sprucehill.mandrill.service.ServiceFactory} or by user
     */
    public void setClient(final JerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    /**
     *
     * @return {@link org.glassfish.jersey.client.JerseyClient} currently set
     */
    public JerseyClient getJerseyClient() {
        return jerseyClient;
    }

    /**
     * @param key set by {@link io.sprucehill.mandrill.service.ServiceFactory} or by user
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     *
     * @return current key for api
     */
    public String getKey() {
        return key;
    }

    <T extends AbstractPayload.Init<T, U>, U extends AbstractPayload> void integrateDefaultValues(AbstractPayload.Init<T, U> payloadBuilder) {
        if (!payloadBuilder.hasKey() && null != key && !key.isEmpty()) {
            payloadBuilder.withKey(key);
        }
    }

    <T, E extends Error> T send(final AbstractPayload payload, final Class<T> responseClass,
                                final Class<E> errorClass) throws E, IOException {
        final Response response = getJerseyClient()
                .target(getBaseUrl())
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

    <T, E extends Error> T send(final AbstractPayload payload, final GenericType<T> responseClass,
                                final Class<E> errorClass) throws E, IOException {
        final Response response = getJerseyClient()
                .target(getBaseUrl())
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
