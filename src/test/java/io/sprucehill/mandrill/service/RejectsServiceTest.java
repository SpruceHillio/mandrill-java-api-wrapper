package io.sprucehill.mandrill.service;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import io.sprucehill.mandrill.AbstractTest;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.request.RejectsAddPayload;
import io.sprucehill.mandrill.data.request.RejectsDeletePayload;
import io.sprucehill.mandrill.data.request.RejectsListPayload;
import io.sprucehill.mandrill.data.response.AnyListAddResponse;
import io.sprucehill.mandrill.data.response.AnyListDeleteResponse;
import io.sprucehill.mandrill.data.response.AnyListListResponse;

public class RejectsServiceTest extends AbstractTest {
    private static final String EMAIL = "reject@test.com";

    @Test
    public void add() throws PreBuildError, IOException {
        final RejectsService rejectsService = new RejectsService();

        final AnyListAddResponse response = rejectsService.add(
                new RejectsAddPayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(EMAIL, response.getEmail());
        Assert.assertTrue(response.isAdded());
    }

    @Test
    public void delete() throws PreBuildError, IOException {
        final RejectsService rejectsService = new RejectsService();

        final AnyListDeleteResponse response = rejectsService.delete(
                new RejectsDeletePayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(EMAIL, response.getEmail());
        Assert.assertTrue(response.isDeleted());
    }

    @Test
    public void list() throws PreBuildError, IOException {
        final RejectsService rejectsService = new RejectsService();

        rejectsService.add(new RejectsAddPayload.Builder().withEmail(EMAIL));

        final List<AnyListListResponse> response = rejectsService.list(
                new RejectsListPayload.Builder().withEmail(EMAIL));

        Assert.assertEquals(1, response.size());
    }
}
