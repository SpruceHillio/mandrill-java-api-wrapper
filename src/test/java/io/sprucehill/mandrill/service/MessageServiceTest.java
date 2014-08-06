package io.sprucehill.mandrill.service;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.request.*;
import io.sprucehill.mandrill.data.response.MessageResponse;

public class MessageServiceTest extends AbstractTest {
    private static final String EMAIL = "test@test.com";
    private static final String TEMPLATE = "testtemplate";
    private static final String FROM_EMAIL = "info@test.com";
    private static final String FROM_NAME = "Testservice";

    @Test
    public void send() throws PreBuildError, IOException {
        final MessageService messageService = new MessageService();

        final List<MessageResponse> response = messageService.sendMessage(
                new MessageSendPayload.Builder().withTo(EMAIL).withSubject("Mandrill Test")
                        .withText("This is an automatic test for emails send using Mandrill"));

        Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }

    @Test
    public void sendWithFrom() throws PreBuildError, IOException {
        final MessageService messageService = new MessageService();
        messageService.setFromEmail(FROM_EMAIL);
        messageService.setFromName(FROM_NAME);

        final List<MessageResponse> response = messageService.sendMessage(
                new MessageSendPayload.Builder().withTo(EMAIL).withSubject("Mandrill Test")
                        .withText("This is an automatic test for emails send using Mandrill"));

        Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }

    @Test
    public void sendTemplate() throws PreBuildError, IOException {
        final MessageService messageService = new MessageService();

        final List<MessageResponse> response = messageService.sendTemplateMessage(
                new MessageSendTemplatePayload.Builder().withTo(EMAIL)
                        .withTemplateName(TEMPLATE));

        Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }
}
