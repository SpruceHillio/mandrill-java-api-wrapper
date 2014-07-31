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
import io.sprucehill.mandrill.data.request.WhitelistsAddPayload;
import io.sprucehill.mandrill.data.request.WhitelistsDeletePayload;
import io.sprucehill.mandrill.data.request.WhitelistsListPayload;
import io.sprucehill.mandrill.data.response.AnyListAddResponse;
import io.sprucehill.mandrill.data.response.AnyListDeleteResponse;
import io.sprucehill.mandrill.data.response.AnyListListResponse;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class WhitelistsService extends AbstractService implements IWhitelistsService {

    @Override
    public List<AnyListAddResponse> add(final WhitelistsAddPayload payload)
            throws MessageError, IOException {
        try {
            final List<AnyListAddResponse> messageResponses =
                    send(payload, List.class, MessageError.class);
            return messageResponses;
        } catch (final MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when adding whitelist!", new Object[]{e.getCode().toString(), e.getName(), e.getMessage()});
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while sending message!");
            throw e;
        }
    }

    @Override
    public List<AnyListAddResponse> add(final WhitelistsAddPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        return add(payloadBuilder.build());
    }

    @Override
    public List<AnyListDeleteResponse> delete(final WhitelistsDeletePayload payload)
            throws MessageError, IOException {
        try {
            final List<AnyListDeleteResponse> messageResponses =
                    send(payload, List.class, MessageError.class);
            return messageResponses;
        } catch (final MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when deleting whitelist!", new Object[]{e.getCode().toString(), e.getName(), e.getMessage()});
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while deleting whitelist!");
            throw e;
        }
    }

    @Override
    public List<AnyListDeleteResponse> delete(final WhitelistsDeletePayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        return delete(payloadBuilder.build());
    }

    @Override
    public List<AnyListListResponse> list(final WhitelistsListPayload payload)
            throws MessageError, IOException {
        try {
            final List<AnyListListResponse> messageResponses =
                    send(payload, List.class, MessageError.class);
            return messageResponses;
        } catch (final MessageError e) {
            LOGGER.warn("Got MessageError with code {}, name {} and message {} when listing whitelists!", new Object[]{e.getCode().toString(), e.getName(), e.getMessage()});
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while listing whitelists!");
            throw e;
        }
    }

    @Override
    public List<AnyListListResponse> list(final WhitelistsListPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException {
        return list(payloadBuilder.build());
    }
}
