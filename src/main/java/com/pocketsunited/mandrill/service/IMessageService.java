package com.pocketsunited.mandrill.service;

import com.pocketsunited.mandrill.data.error.MessageError;
import com.pocketsunited.mandrill.data.error.TemplateMessageError;
import com.pocketsunited.mandrill.data.request.MessagePayload;
import com.pocketsunited.mandrill.data.request.TemplateMessagePayload;
import com.pocketsunited.mandrill.data.response.MessageResponse;

import java.io.IOException;
import java.util.List;

public interface IMessageService {

    List<MessageResponse> sendMessage(MessagePayload payload) throws MessageError, IOException;

    List<MessageResponse> sendTemplateMessage(TemplateMessagePayload payload) throws TemplateMessageError, IOException;
}