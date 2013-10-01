package com.pocketsunited.mandrill.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pocketsunited.mandrill.data.AbstractJsonBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public class RenderTemplatePayload extends AbstractPayload {

    @Override
    public String getPath() {
        return "/templates/render.json";
    }

    public static final class Variable extends AbstractJsonBase {

        @JsonProperty
        protected String name;

        @JsonProperty
        protected String content;

        protected Variable() {}

        protected Variable(String name, String content) {
            this.name = name;
            this.content = content;
        }

        @Override
        public int hashCode() {
            return null == name ? super.hashCode() : name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) {
                return false;
            }
            if (!Variable.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == name ? super.equals(o) : name.equals(((Variable)o).name);
        }
    }

    @JsonProperty(
            value = "template_name")
    protected String templateName;

    @JsonProperty(
            value = "template_content")
    @JsonInclude(
            value = JsonInclude.Include.NON_NULL)
    protected List<Variable> templateContent = new ArrayList<Variable>();

    @JsonProperty(
            value = "merge_vars")
    protected List<Variable> mergeVars = new ArrayList<Variable>();


    protected static abstract class Init<T extends Init<T,U>, U extends RenderTemplatePayload> extends AbstractPayload.Init<T,U> {

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

        public T withMergeVar(String name, String content) {
            Variable variable = new Variable(name,content);
            if (!object.mergeVars.contains(variable)) {
                object.mergeVars.add(variable);
            }
            return self();
        }
    }

    public static class Builder extends Init<Builder,RenderTemplatePayload> {

        public Builder() {
            super(new RenderTemplatePayload());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
