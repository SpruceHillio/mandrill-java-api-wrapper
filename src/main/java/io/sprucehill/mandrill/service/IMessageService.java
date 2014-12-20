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

import io.sprucehill.mandrill.data.error.MessageError;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.TemplateMessageError;
import io.sprucehill.mandrill.data.request.MessageSendPayload;
import io.sprucehill.mandrill.data.request.MessageSendTemplatePayload;
import io.sprucehill.mandrill.data.response.MessageResponse;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public interface IMessageService {

    /**
     * @return
     * @throws MessageError
     * @throws IOException
     */
    List<MessageResponse> sendMessage(final MessageSendPayload payload)
            throws MessageError, IOException;

    /**
     * @return
     * @throws PreBuildError
     * @throws MessageError
     * @throws IOException
     */
    List<MessageResponse> sendMessage(final MessageSendPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException;

    /**
     * @return
     * @throws TemplateMessageError
     * @throws IOException
     */
    List<MessageResponse> sendTemplateMessage(final MessageSendTemplatePayload payload)
            throws TemplateMessageError, IOException;

    /**
     * @return
     * @throws PreBuildError
     * @throws TemplateMessageError
     * @throws IOException
     */
    List<MessageResponse> sendTemplateMessage(final MessageSendTemplatePayload.Builder payloadBuilder)
            throws PreBuildError, TemplateMessageError, IOException;

    /**
     * @param fromEmail email set if missing from builder
     */
    void setFromEmail(final String fromEmail);

    /**
     * @param fromName name set if missing from builder
     */
    void setFromName(final String fromName);
}