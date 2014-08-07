package io.sprucehill.mandrill.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.RenderTemplateError;
import io.sprucehill.mandrill.data.request.TemplateAddPayload;
import io.sprucehill.mandrill.data.request.TemplateDeletePayload;
import io.sprucehill.mandrill.data.request.TemplateRenderPayload;
import io.sprucehill.mandrill.data.request.TemplateUpdatePayload;
import io.sprucehill.mandrill.data.response.TemplateResponse;

public class TemplateServiceTest extends AbstractTest {
    private static final String TEMPLATE = "testtemplate" + System.currentTimeMillis();

    @Test
    public void add() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        try {
            final TemplateResponse response = messageService.add(
                    new TemplateAddPayload.Builder().withName(TEMPLATE));

            Assert.assertEquals(TEMPLATE, response.getName());
        } finally {
            delete();
        }

    }

    @Test
    public void update() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        try {
            try {
                messageService.add(new TemplateAddPayload.Builder().withName(TEMPLATE));
            } catch (final RenderTemplateError e) {
                // Ignore
            }

            final TemplateResponse response = messageService.update(
                    new TemplateUpdatePayload.Builder().withName(TEMPLATE));

            Assert.assertEquals(TEMPLATE, response.getName());
        } finally {
            delete();
        }
    }


    @Test
    public void render() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        try {
            try {
                messageService.add(new TemplateAddPayload.Builder().withName(TEMPLATE));
            } catch (final RenderTemplateError e) {
                // Ignore
            }

            final String response = messageService.render(
                    new TemplateRenderPayload.Builder().withTemplateName(TEMPLATE));
        } finally {
            delete();
        }

        //Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }

    public void delete() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        try {
            final TemplateResponse response = messageService.delete(
                    new TemplateDeletePayload.Builder().withName(TEMPLATE));
        } catch (RenderTemplateError ex) {
            // Ignore
        }

        //Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }
}
