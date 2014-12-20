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

import org.junit.Assert;
import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.RenderTemplateError;
import io.sprucehill.mandrill.data.request.TemplateAddPayload;
import io.sprucehill.mandrill.data.request.TemplateDeletePayload;
import io.sprucehill.mandrill.data.request.TemplateRenderPayload;
import io.sprucehill.mandrill.data.request.TemplateUpdatePayload;
import io.sprucehill.mandrill.data.response.TemplateResponse;

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public class TemplateServiceTest extends AbstractTest {
    private static final String TEMPLATE = "testtemplate" + System.currentTimeMillis();

    @Test
    public void add() throws PreBuildError, IOException {
        final ITemplateService templateService = serviceFactory.createTemplateService();

        try {
            final TemplateResponse response = templateService.add(
                    new TemplateAddPayload.Builder().withName(TEMPLATE));

            Assert.assertEquals(TEMPLATE, response.getName());
        } finally {
            delete();
        }

    }

    @Test
    public void update() throws PreBuildError, IOException {
        final ITemplateService templateService = serviceFactory.createTemplateService();

        try {
            try {
                templateService.add(new TemplateAddPayload.Builder().withName(TEMPLATE));
            } catch (final RenderTemplateError e) {
                // Ignore
            }

            final TemplateResponse response = templateService.update(
                    new TemplateUpdatePayload.Builder().withName(TEMPLATE));

            Assert.assertEquals(TEMPLATE, response.getName());
        } finally {
            delete();
        }
    }


    @Test
    public void render() throws PreBuildError, IOException {
        final ITemplateService templateService = serviceFactory.createTemplateService();

        try {
            try {
                templateService.add(new TemplateAddPayload.Builder().withName(TEMPLATE));
            } catch (final RenderTemplateError e) {
                // Ignore
            }

            final String response = templateService.render(
                    new TemplateRenderPayload.Builder().withTemplateName(TEMPLATE));
        } finally {
            delete();
        }

        //Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }

    public void delete() throws PreBuildError, IOException {
        final ITemplateService templateService = serviceFactory.createTemplateService();

        try {
            final TemplateResponse response = templateService.delete(
                    new TemplateDeletePayload.Builder().withName(TEMPLATE));
        } catch (RenderTemplateError ex) {
            // Ignore
        }

        //Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }
}
