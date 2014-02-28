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

import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.mandrill.data.error.MessageError;
import io.sprucehill.mandrill.data.error.PreBuildError;
import io.sprucehill.mandrill.data.error.RenderTemplateError;
import io.sprucehill.mandrill.data.request.RenderTemplatePayload;
import io.sprucehill.mandrill.data.response.RenderTemplateResponse;

import java.io.IOException;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TemplateService extends AbstractService implements ITemplateService {

    @Override
    public String render(RenderTemplatePayload payload) throws RenderTemplateError, IOException {
        try {
            RenderTemplateResponse renderTemplateResponse = send(payload,new TypeReference<RenderTemplateResponse>() {},RenderTemplateError.class);
            return renderTemplateResponse.getHtml();
        }
        catch (MessageError e) {
            logger.warn("Got RenderTemplateError with code {}, name {} and message {} when rendering template!",new Object[] {e.getCode().toString(),e.getName(),e.getMessage()});
            throw e;
        }
        catch (IOException e) {
            logger.error("Got IOException while rendering template!");
            throw e;
        }
    }

    @Override
    public String render(RenderTemplatePayload.Builder payloadBuilder) throws PreBuildError, RenderTemplateError,IOException {
        integrateDefaultValues(payloadBuilder);
        return render(payloadBuilder.build());
    }
}
