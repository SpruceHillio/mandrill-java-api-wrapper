package com.pocketsunited.mandrill.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pocketsunited.mandrill.data.error.MessageError;
import com.pocketsunited.mandrill.data.error.TemplateMessageError;
import com.pocketsunited.mandrill.data.request.MessagePayload;
import com.pocketsunited.mandrill.data.request.TemplateMessagePayload;
import com.pocketsunited.mandrill.data.response.MessageResponse;

import java.io.IOException;
import java.util.List;

public class MessageService extends AbstractService implements IMessageService {

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
}