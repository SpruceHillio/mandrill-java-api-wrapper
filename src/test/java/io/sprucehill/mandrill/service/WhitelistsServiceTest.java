package io.sprucehill.mandrill.service;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.request.WhitelistsAddPayload;
import io.sprucehill.mandrill.data.request.WhitelistsDeletePayload;
import io.sprucehill.mandrill.data.request.WhitelistsListPayload;
import io.sprucehill.mandrill.data.response.AnyListAddResponse;
import io.sprucehill.mandrill.data.response.AnyListDeleteResponse;
import io.sprucehill.mandrill.data.response.AnyListListResponse;

import org.junit.Assert;

public class WhitelistsServiceTest extends AbstractTest {
    private static final String EMAIL = "whitelist@test.com";

    @Test
    public void add() throws PreBuildError, IOException {
        final WhitelistsService whitelistsService = new WhitelistsService();

        final AnyListAddResponse response = whitelistsService.add(
                new WhitelistsAddPayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(EMAIL, response.getEmail());
        Assert.assertTrue(response.isAdded());
    }

    @Test
    public void delete() throws PreBuildError, IOException {
        final WhitelistsService whitelistsService = new WhitelistsService();


        final AnyListDeleteResponse response = whitelistsService.delete(
                new WhitelistsDeletePayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(EMAIL, response.getEmail());
        Assert.assertTrue(response.isDeleted());
    }

    @Test
    public void list() throws PreBuildError, IOException {
        final WhitelistsService whitelistsService = new WhitelistsService();

        whitelistsService.add(new WhitelistsAddPayload.Builder().withEmail(EMAIL));

        final List<AnyListListResponse> response = whitelistsService.list(
                new WhitelistsListPayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(1, response.size());
    }
}
