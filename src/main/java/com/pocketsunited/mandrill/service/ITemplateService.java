package com.pocketsunited.mandrill.service;

import com.pocketsunited.mandrill.data.error.PreBuildError;
import com.pocketsunited.mandrill.data.error.RenderTemplateError;
import com.pocketsunited.mandrill.data.request.RenderTemplatePayload;

import java.io.IOException;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public interface ITemplateService {

    /**
     *
     * @param payload
     * @return
     * @throws RenderTemplateError
     * @throws IOException
     */
    String render(RenderTemplatePayload payload) throws RenderTemplateError,IOException;

    /**
     *
     * @param payloadBuilder
     * @return
     * @throws PreBuildError
     * @throws RenderTemplateError
     * @throws IOException
     */
    String render(RenderTemplatePayload.Builder payloadBuilder) throws PreBuildError, RenderTemplateError,IOException;
}
