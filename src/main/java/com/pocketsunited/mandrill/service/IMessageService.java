package com.pocketsunited.mandrill.service;

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
public interface IMessageService {

    /**
     *
     * @param payload
     * @return
     * @throws MessageError
     * @throws IOException
     */
    List<MessageResponse> sendMessage(MessagePayload payload) throws MessageError, IOException;

    /**
     *
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws MessageError
     * @throws IOException
     */
    List<MessageResponse> sendMessage(MessagePayload.Builder payloadBuilder) throws PreBuildError, MessageError, IOException;

    /**
     *
     * @param payload
     * @return
     * @throws TemplateMessageError
     * @throws IOException
     */
    List<MessageResponse> sendTemplateMessage(TemplateMessagePayload payload) throws TemplateMessageError, IOException;

    /**
     *
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws TemplateMessageError
     * @throws IOException
     */
    List<MessageResponse> sendTemplateMessage(TemplateMessagePayload.Builder payloadBuilder) throws PreBuildError, TemplateMessageError, IOException;
}