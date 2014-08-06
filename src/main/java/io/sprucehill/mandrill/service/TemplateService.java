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
import io.sprucehill.mandrill.data.error.RenderTemplateError;
import io.sprucehill.mandrill.data.request.*;
import io.sprucehill.mandrill.data.response.TemplateRenderResponse;
import io.sprucehill.mandrill.data.response.TemplateResponse;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TemplateService extends AbstractService implements ITemplateService {

    @Override
    public String render(final TemplateRenderPayload payload)
            throws RenderTemplateError, IOException {
        try {
            final TemplateRenderResponse templateRenderResponse =
                    send(payload, TemplateRenderResponse.class, RenderTemplateError.class);
            return templateRenderResponse.getHtml();
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
    public String render(final TemplateRenderPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return render(payloadBuilder.build());
    }

    @Override
    public TemplateResponse add(final TemplateAddPayload payload)
            throws RenderTemplateError, IOException {
        try {
            final TemplateResponse templateResponse =
                    send(payload, TemplateResponse.class, RenderTemplateError.class);
            return templateResponse;
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
    public TemplateResponse add(final TemplateAddPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return add(payloadBuilder.build());
    }

    @Override
    public TemplateResponse update(final TemplateUpdatePayload payload)
            throws RenderTemplateError, IOException {
        try {
            final TemplateResponse templateResponse =
                    send(payload, TemplateResponse.class, RenderTemplateError.class);
            return templateResponse;
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
    public TemplateResponse update(final TemplateUpdatePayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return update(payloadBuilder.build());
    }

    @Override
    public TemplateResponse publish(final TemplatePublishPayload payload)
            throws RenderTemplateError, IOException {
        try {
            final TemplateResponse templateResponse =
                    send(payload, TemplateResponse.class, RenderTemplateError.class);
            return templateResponse;
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
    public TemplateResponse publish(final TemplatePublishPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return publish(payloadBuilder.build());
    }

    @Override
    public TemplateResponse delete(final TemplateDeletePayload payload)
            throws RenderTemplateError, IOException {
        try {
            final TemplateResponse templateResponse =
                    send(payload, TemplateResponse.class, RenderTemplateError.class);
            return templateResponse;
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
    public TemplateResponse delete(final TemplateDeletePayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return delete(payloadBuilder.build());
    }


    @Override
    public TemplateResponse info(final TemplateInfoPayload payload)
            throws RenderTemplateError, IOException {
        try {
            final TemplateResponse templateResponse =
                    send(payload, TemplateResponse.class, RenderTemplateError.class);
            return templateResponse;
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
    public TemplateResponse info(final TemplateInfoPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return info(payloadBuilder.build());
    }

    @Override
    public List<TemplateResponse> list(final TemplateListPayload payload)
            throws RenderTemplateError, IOException {
        try {
            final List<TemplateResponse> templateResponse =
                    send(payload, List.class, RenderTemplateError.class);
            return templateResponse;
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
    public List<TemplateResponse> list(final TemplateListPayload.Builder payloadBuilder)
            throws PreBuildError, RenderTemplateError, IOException {
        integrateDefaultValues(payloadBuilder);
        return list(payloadBuilder.build());
    }

}
