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

import io.sprucehill.mandrill.data.error.MessageError;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.RenderTemplateError;
import io.sprucehill.mandrill.data.request.RenderTemplatePayload;
import io.sprucehill.mandrill.data.response.RenderTemplateResponse;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TemplateService extends AbstractService implements ITemplateService {

    @Override
    public String render(final RenderTemplatePayload payload)
            throws RenderTemplateError, IOException {
        try {
            final RenderTemplateResponse renderTemplateResponse =
                    send(payload, RenderTemplateResponse.class, RenderTemplateError.class);
            return renderTemplateResponse.getHtml();
        } catch (final MessageError e) {
            LOGGER.warn("Got RenderTemplateError with code {}, name {} and message {} when " +
                    "rendering template!", e.getCode().toString(), e.getName(), e.getMessage());
            throw e;
        } catch (final IOException e) {
            LOGGER.error("Got IOException while rendering template!");
            throw e;
        }
    }

    @Override
    public String render(final RenderTemplatePayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return render(payloadBuilder.build());
    }
}
