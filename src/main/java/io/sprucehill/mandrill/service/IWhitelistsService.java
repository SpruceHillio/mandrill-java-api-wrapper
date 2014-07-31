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
public interface IWhitelistsService {
    /**
     * @param payload
     * @return
     * @throws io.sprucehill.mandrill.data.error.MessageError
     * @throws java.io.IOException
     */
    List<AnyListAddResponse> add(final WhitelistsAddPayload payload)
            throws MessageError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws io.sprucehill.mandrill.data.error.PreBuildError
     * @throws io.sprucehill.mandrill.data.error.MessageError
     * @throws java.io.IOException
     */
    List<AnyListAddResponse> add(final WhitelistsAddPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException;

    /**
     * @param payload
     * @return
     * @throws io.sprucehill.mandrill.data.error.MessageError
     * @throws java.io.IOException
     */
    List<AnyListDeleteResponse> delete(final WhitelistsDeletePayload payload)
            throws MessageError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws io.sprucehill.mandrill.data.error.PreBuildError
     * @throws io.sprucehill.mandrill.data.error.MessageError
     * @throws java.io.IOException
     */
    List<AnyListDeleteResponse> delete(final WhitelistsDeletePayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException;

    /**
     * @param payload
     * @return
     * @throws io.sprucehill.mandrill.data.error.MessageError
     * @throws java.io.IOException
     */
    List<AnyListListResponse> list(final WhitelistsListPayload payload)
            throws MessageError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws io.sprucehill.mandrill.data.error.PreBuildError
     * @throws io.sprucehill.mandrill.data.error.MessageError
     * @throws java.io.IOException
     */
    List<AnyListListResponse> list(final WhitelistsListPayload.Builder payloadBuilder)
            throws PreBuildError, MessageError, IOException;

}