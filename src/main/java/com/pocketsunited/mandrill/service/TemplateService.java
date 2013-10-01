package com.pocketsunited.mandrill.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pocketsunited.mandrill.data.error.MessageError;
import com.pocketsunited.mandrill.data.error.RenderTemplateError;
import com.pocketsunited.mandrill.data.request.RenderTemplatePayload;
import com.pocketsunited.mandrill.data.response.RenderTemplateResponse;

import java.io.IOException;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
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
}
