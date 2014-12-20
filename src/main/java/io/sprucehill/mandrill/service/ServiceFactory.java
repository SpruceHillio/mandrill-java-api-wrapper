/*
Copyright 2014 SpruceHill.io GmbH 2014 Stephan Wienczny

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

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jersey.repackaged.com.google.common.base.Objects;

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public class ServiceFactory {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String baseUrl = "https://mandrillapp.com/api/1.0";

    private JerseyClient jerseyClient;

    private String key;

    public ServiceFactory() {
    }

    public ServiceFactory(final String key) {
        this.key = key;
    }

    public ServiceFactory(final String key, final String baseUrl) {
        this(key);
        this.baseUrl = baseUrl;
    }

    public ServiceFactory(final String key, final String baseUrl, final JerseyClient jerseyClient) {
        this(key, baseUrl);
        this.jerseyClient = jerseyClient;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public JerseyClient getJerseyClient() {
        if (jerseyClient == null) {
            synchronized (ServiceFactory.class) {
                if (jerseyClient == null) {
                    jerseyClient = JerseyClientBuilder.createClient();
                }
            }
        }
        return jerseyClient;
    }

    public void setJerseyClient(final JerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public IMessageService createMessageService() {
        return assignConfiguration(new MessageService());
    }

    public IRejectsService createRejectsService() {
        return assignConfiguration(new RejectsService());
    }

    public ITemplateService createTemplateService() {
        return assignConfiguration(new TemplateService());
    }

    public IWhitelistsService createWhitelistsService() {
        return assignConfiguration(new WhitelistsService());
    }

    public <S extends AbstractService> S assignConfiguration(S service) {
        service.setBaseUrl(getBaseUrl());
        service.setKey(getKey());
        service.setClient(getJerseyClient());
        return service;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("jerseyClient", jerseyClient)
                .add("baseUrl", baseUrl)
                .add("key", key)
                .toString();
    }
}
