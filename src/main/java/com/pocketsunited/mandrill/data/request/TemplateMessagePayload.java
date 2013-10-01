package com.pocketsunited.mandrill.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TemplateMessagePayload extends MessagePayload {

    @Override
    public String getPath() {
        return "/messages/send-template.json";
    }

    @JsonProperty(
            value = "template_name")
    protected String templateName;

    @JsonProperty(
            value = "template_content")
    @JsonInclude(
            value = JsonInclude.Include.NON_NULL)
    protected List<Variable> templateContent = new ArrayList<Variable>();

    protected static abstract class Init<T extends Init<T,U>, U extends TemplateMessagePayload> extends MessagePayload.Init<T,U> {

        protected Init(U object) {
            super(object);
        }

        public T withTemplateName(String templateName) {
            object.templateName = templateName;
            return self();
        }

        public T withTemplateContent(String name, String content) {
            Variable variable = new Variable(name,content);
            if (!object.templateContent.contains(variable)) {
                object.templateContent.add(variable);
            }
            return self();
        }
    }

    public static class Builder extends Init<Builder,TemplateMessagePayload> {

        public Builder() {
            super(new TemplateMessagePayload());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
