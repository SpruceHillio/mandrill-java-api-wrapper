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
import io.sprucehill.mandrill.data.request.WhitelistsAddPayload;
import io.sprucehill.mandrill.data.request.WhitelistsDeletePayload;
import io.sprucehill.mandrill.data.request.WhitelistsListPayload;
import io.sprucehill.mandrill.data.response.AnyListAddResponse;
import io.sprucehill.mandrill.data.response.AnyListDeleteResponse;
import io.sprucehill.mandrill.data.response.AnyListListResponse;

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public class WhitelistsServiceTest extends AbstractTest {
    private static final String EMAIL = "whitelist@test.com";

    @Test
    public void add() throws PreBuildError, IOException {
        final IWhitelistsService whitelistsService = mandrillServiceFactory.createWhitelistsService();

        final AnyListAddResponse response = whitelistsService.add(
                new WhitelistsAddPayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(EMAIL, response.getEmail());
        Assert.assertTrue(response.isAdded());
    }

    @Test
    public void delete() throws PreBuildError, IOException {
        final IWhitelistsService whitelistsService = mandrillServiceFactory.createWhitelistsService();

        final AnyListDeleteResponse response = whitelistsService.delete(
                new WhitelistsDeletePayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(EMAIL, response.getEmail());
        Assert.assertTrue(response.isDeleted());
    }

    @Test
    public void list() throws PreBuildError, IOException {
        final IWhitelistsService whitelistsService = mandrillServiceFactory.createWhitelistsService();

        whitelistsService.add(new WhitelistsAddPayload.Builder().withEmail(EMAIL));

        final List<AnyListListResponse> response = whitelistsService.list(
                new WhitelistsListPayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(1, response.size());
    }
}
