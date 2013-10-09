package com.pocketsunited.mandrill.data.request;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public interface IWithTemplateContentPayloadBuilder<T> {

    T withTemplateContent(String name, String content);
}
