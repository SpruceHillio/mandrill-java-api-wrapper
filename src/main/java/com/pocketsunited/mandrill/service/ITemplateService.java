package com.pocketsunited.mandrill.service;

import com.pocketsunited.mandrill.data.error.RenderTemplateError;
import com.pocketsunited.mandrill.data.request.RenderTemplatePayload;

import java.io.IOException;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public interface ITemplateService {

    String render(RenderTemplatePayload payload) throws RenderTemplateError,IOException;
}
