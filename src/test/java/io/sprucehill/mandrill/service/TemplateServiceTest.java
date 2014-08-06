package io.sprucehill.mandrill.service;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.request.TemplateAddPayload;
import io.sprucehill.mandrill.data.request.TemplateRenderPayload;
import io.sprucehill.mandrill.data.request.TemplateUpdatePayload;
import io.sprucehill.mandrill.data.response.TemplateResponse;

public class TemplateServiceTest extends AbstractTest {
    private static final String TEMPLATE = "testtemplate";

    @Ignore
    @Test
    public void add() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        final TemplateResponse response = messageService.add(
                new TemplateAddPayload.Builder().withName(TEMPLATE));

        Assert.assertEquals(TEMPLATE, response.getName());
    }

    @Test
    public void update() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        final TemplateResponse response = messageService.update(
                new TemplateUpdatePayload.Builder().withName(TEMPLATE));

        Assert.assertEquals(TEMPLATE, response.getName());
    }


    @Test
    public void render() throws PreBuildError, IOException {
        final TemplateService messageService = new TemplateService();

        final String response = messageService.render(
                new TemplateRenderPayload.Builder().withTemplateName(TEMPLATE));

        //Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }
}
