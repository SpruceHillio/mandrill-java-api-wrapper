package com.pocketsunited.mandrill.data.request;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public interface IWithTemplateNamePayloadBuilder<T> {

    T withTemplateName(String templateName);
}
