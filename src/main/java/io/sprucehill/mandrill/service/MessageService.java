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
import java.util.List;

import io.sprucehill.mandrill.data.error.MessageError;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.TemplateMessageError;
import io.sprucehill.mandrill.data.request.MessageSendPayload;
import io.sprucehill.mandrill.data.request.MessageSendTemplatePayload;
import io.sprucehill.mandrill.data.response.MessageResponse;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class MessageService extends AbstractService implements IMessageService {

    private String fromEmail;

    private String fromName;

    public void setFromEmail(final String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setFromName(final String fromName) {
        this.fromName = fromName;
    }

    @Override
    public List<MessageResponse> sendMessage(final MessageSendPayload payload) throws MessageError, IOException {
        try {
            final List<MessageResponse> messageResponses =
                    send(payload, List.class, MessageError.class);
            return messageResponses;
        } catch (MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when sending message!",
                    e.getCode().toString(), e.getName(), e.getMessage());
            throw e;
        } catch (IOException e) {
            LOGGER.error("Got IOException while sending message!");
            throw e;
        }
    }

    @Override
    public List<MessageResponse> sendMessage(final MessageSendPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return sendMessage(payloadBuilder.build());
    }

    @Override
    public List<MessageResponse> sendTemplateMessage(final MessageSendTemplatePayload payload)
            throws TemplateMessageError, IOException {
        try {
            final List<MessageResponse> messageResponses =
                    send(payload, List.class, MessageError.class);
            return messageResponses;
        } catch (MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when sending message!",
                    e.getCode().toString(), e.getName(), e.getMessage());
            throw e;
        } catch (IOException e) {
            LOGGER.error("Got IOException while sending message!");
            throw e;
        }
    }

    public List<MessageResponse> sendTemplateMessage(
            final MessageSendTemplatePayload.Builder payloadBuilder)
            throws PreBuildError, TemplateMessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return sendTemplateMessage(payloadBuilder.build());
    }

    <T extends MessageSendPayload.Init<T, U>, U extends MessageSendPayload> void integrateDefaultValues(
            final MessageSendPayload.Init<T, U> payloadBuilder) {
        super.integrateDefaultValues(payloadBuilder);
        if (!payloadBuilder.hasFromEmail() && null != fromEmail && !fromEmail.isEmpty()) {
            payloadBuilder.withFromEmail(fromEmail);
        }
        if (!payloadBuilder.hasFromName() && null != fromName && !fromName.isEmpty()) {
            payloadBuilder.withFromName(fromName);
        }
    }
}
