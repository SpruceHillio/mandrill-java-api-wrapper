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
import io.sprucehill.mandrill.data.request.MessageSendPayload;
import io.sprucehill.mandrill.data.request.WhitelistsAddPayload;
import io.sprucehill.mandrill.data.request.WhitelistsDeletePayload;
import io.sprucehill.mandrill.data.request.WhitelistsListPayload;
import io.sprucehill.mandrill.data.response.AnyListAddResponse;
import io.sprucehill.mandrill.data.response.AnyListDeleteResponse;
import io.sprucehill.mandrill.data.response.AnyListListResponse;
import io.sprucehill.mandrill.data.response.AnyListListResponseGenericType;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class WhitelistsService extends AbstractService implements IWhitelistsService {

    @Override
    public AnyListAddResponse add(final WhitelistsAddPayload payload)
            throws MessageError, IOException {
        try {
            final AnyListAddResponse messageResponses =
                    send(payload, AnyListAddResponse.class, MessageError.class);
            return messageResponses;
        } catch (final MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when adding whitelist!",
                    e.getCode().toString(), e.getName(), e.getMessage());
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while sending message!");
            throw e;
        }
    }

    @Override
    public AnyListAddResponse add(final WhitelistsAddPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return add(payloadBuilder.build());
    }

    @Override
    public AnyListDeleteResponse delete(final WhitelistsDeletePayload payload)
            throws MessageError, IOException {
        try {
            final AnyListDeleteResponse messageResponses =
                    send(payload, AnyListDeleteResponse.class, MessageError.class);
            return messageResponses;
        } catch (final MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when deleting whitelist!", e.getCode().toString(), e.getName(), e.getMessage());
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while deleting whitelist!");
            throw e;
        }
    }

    @Override
    public AnyListDeleteResponse delete(final WhitelistsDeletePayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return delete(payloadBuilder.build());
    }

    @Override
    public List<AnyListListResponse> list(final WhitelistsListPayload payload)
            throws MessageError, IOException {
        try {
            final List<AnyListListResponse> messageResponses =
                    send(payload, new AnyListListResponseGenericType(), MessageError.class);
            return messageResponses;
        } catch (final MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when listing whitelists!",
                    e.getCode().toString(), e.getName(), e.getMessage());
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while listing whitelists!");
            throw e;
        }
    }

    @Override
    public List<AnyListListResponse> list(final WhitelistsListPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        integrateDefaultValues(payloadBuilder);
        return list(payloadBuilder.build());
    }
}
