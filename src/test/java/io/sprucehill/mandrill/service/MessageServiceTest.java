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
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.request.MessageSendPayload;
import io.sprucehill.mandrill.data.request.MessageSendTemplatePayload;
import io.sprucehill.mandrill.data.response.MessageResponse;

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public class MessageServiceTest extends AbstractTest {
    private static final String EMAIL = "test@test.com";
    private static final String TEMPLATE = "testtemplate";
    private static final String FROM_EMAIL = "info@test.com";
    private static final String FROM_NAME = "Testservice";

    @Test
    public void send() throws PreBuildError, IOException {
        final IMessageService messageService = serviceFactory.createMessageService();

        final List<MessageResponse> response = messageService.sendMessage(
                new MessageSendPayload.Builder().withTo(EMAIL).withSubject("Mandrill Test")
                        .withText("This is an automatic test for emails send using Mandrill"));

        Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }

    @Test
    public void sendWithFrom() throws PreBuildError, IOException {
        final IMessageService messageService = new MessageService();

        final List<MessageResponse> response = messageService.sendMessage(
                new MessageSendPayload.Builder().withTo(EMAIL).withFromEmail(FROM_EMAIL)
                        .withFromName(FROM_NAME).withSubject("Mandrill Test")
                        .withText("This is an automatic test for emails send using Mandrill"));

        Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }

    @Test
    public void sendWithFromUsingDefaults() throws PreBuildError, IOException {
        final IMessageService messageService = new MessageService();
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
        final IMessageService messageService = serviceFactory.createMessageService();

        final List<MessageResponse> response = messageService.sendTemplateMessage(
                new MessageSendTemplatePayload.Builder().withTo(EMAIL)
                        .withTemplateName(TEMPLATE));

        Assert.assertFalse(response.isEmpty());
        //Assert.assertEquals(EMAIL, response.getEmail());
        //Assert.assertEquals(MessageResponse.Status.SENT, response.getStatus());
    }
}
