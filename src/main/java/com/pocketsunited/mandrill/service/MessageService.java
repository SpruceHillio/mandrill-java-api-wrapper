package com.pocketsunited.mandrill.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pocketsunited.mandrill.data.error.MessageError;
import com.pocketsunited.mandrill.data.error.PreBuildError;
import com.pocketsunited.mandrill.data.error.TemplateMessageError;
import com.pocketsunited.mandrill.data.request.MessagePayload;
import com.pocketsunited.mandrill.data.request.TemplateMessagePayload;
import com.pocketsunited.mandrill.data.response.MessageResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public class MessageService extends AbstractService implements IMessageService {

    private String fromEmail;

    private String fromName;

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @Override
    public List<MessageResponse> sendMessage(MessagePayload payload) throws MessageError, IOException {
        try {
            List<MessageResponse> messageResponses = send(payload,new TypeReference<List<MessageResponse>>() {},MessageError.class);
            return messageResponses;
        }
        catch (MessageError e) {
            logger.warn("Got MessageError with code {}, name {} and message {} when sending message!",new Object[] {e.getCode().toString(),e.getName(),e.getMessage()});
            throw e;
        }
        catch (IOException e) {
            logger.error("Got IOException while sending message!");
            throw e;
        }
    }

    @Override
    public List<MessageResponse> sendMessage(MessagePayload.Builder payloadBuilder) throws PreBuildError, MessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return sendMessage(payloadBuilder.build());
    }

    @Override
    public List<MessageResponse> sendTemplateMessage(TemplateMessagePayload payload) throws TemplateMessageError, IOException {
        try {
            List<MessageResponse> messageResponses = send(payload,new TypeReference<List<MessageResponse>>() {},MessageError.class);
            return messageResponses;
        }
        catch (MessageError e) {
            logger.warn("Got MessageError with code {}, name {} and message {} when sending message!",new Object[] {e.getCode().toString(),e.getName(),e.getMessage()});
            throw e;
        }
        catch (IOException e) {
            logger.error("Got IOException while sending message!");
            throw e;
        }
    }

    public List<MessageResponse> sendTemplateMessage(TemplateMessagePayload.Builder payloadBuilder) throws PreBuildError, TemplateMessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return sendTemplateMessage(payloadBuilder.build());
    }

    <T extends MessagePayload.Init<T, U>, U extends MessagePayload> void integrateDefaultValues(MessagePayload.Init<T, U> payloadBuilder) {
        super.integrateDefaultValues(payloadBuilder);
        if (!payloadBuilder.hasFromEmail() && null != fromEmail && !fromEmail.isEmpty()) {
            payloadBuilder.withFromEmail(fromEmail);
        }
        if (!payloadBuilder.hasFromName() && null != fromName && !fromName.isEmpty()) {
            payloadBuilder.withFromName(fromName);
        }
    }
}