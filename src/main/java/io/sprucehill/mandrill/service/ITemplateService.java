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

import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.RenderTemplateError;
import io.sprucehill.mandrill.data.request.*;
import io.sprucehill.mandrill.data.response.TemplateResponse;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public interface ITemplateService {

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    String render(final TemplateRenderPayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    String render(final TemplateRenderPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse add(final TemplateAddPayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse add(final TemplateAddPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse update(final TemplateUpdatePayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse update(final TemplateUpdatePayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse publish(final TemplatePublishPayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse publish(final TemplatePublishPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse delete(final TemplateDeletePayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse delete(final TemplateDeletePayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse info(final TemplateInfoPayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    TemplateResponse info(final TemplateInfoPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;

    /**
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    List<TemplateResponse> list(final TemplateListPayload payload) throws RenderTemplateError, IOException;

    /**
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    List<TemplateResponse> list(final TemplateListPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException;


}
