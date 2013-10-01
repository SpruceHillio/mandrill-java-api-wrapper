package com.pocketsunited.mandrill.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public class RenderTemplateResponse extends Response {

    @JsonProperty
    private String html;

    public String getHtml() {
        return html;
    }

    @Override
    public String toString() {
        return new StringBuilder("RenderTemplateResponse [html: ").
                append(html).
                append("]").
                toString();
    }
}