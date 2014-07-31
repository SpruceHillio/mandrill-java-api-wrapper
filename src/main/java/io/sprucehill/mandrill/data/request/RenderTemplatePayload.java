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

package io.sprucehill.mandrill.data.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.sprucehill.mandrill.data.AbstractJsonBase;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class RenderTemplatePayload extends AbstractPayload {

    public static final String PRE_BUILD_TEMPLATE_NAME_NOT_SET = "TEMPLATE_NAME_NOT_SET";
    @JsonProperty(value = "template_name")
    protected String templateName;
    @JsonProperty(value = "template_content")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    protected List<Variable> templateContent = new ArrayList<Variable>();
    @JsonProperty(value = "merge_vars")
    protected List<Variable> mergeVars = new ArrayList<Variable>();

    @Override
    public String getPath() {
        return "/templates/render.json";
    }

    public static final class Variable extends AbstractJsonBase {

        @JsonProperty
        protected String name;

        @JsonProperty
        protected String content;

        protected Variable() {
        }

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

            return null == name ? super.equals(o) : name.equals(((Variable) o).name);
        }
    }

    protected static abstract class Init<T extends Init<T, U>, U extends RenderTemplatePayload> extends AbstractPayload.Init<T, U> implements IWithTemplateNamePayloadBuilder<T>, IWithTemplateContentPayloadBuilder<T>, IWithMergeVarPayloadBuilder<T> {

        protected Init(U object) {
            super(object);
        }

        public T withTemplateName(String templateName) {
            object.templateName = templateName;
            return self();
        }

        public T withTemplateContent(String name, String content) {
            Variable variable = new Variable(name, content);
            if (!object.templateContent.contains(variable)) {
                object.templateContent.add(variable);
            }
            return self();
        }

        public T withMergeVar(String name, String content) {
            Variable variable = new Variable(name, content);
            if (!object.mergeVars.contains(variable)) {
                object.mergeVars.add(variable);
            }
            return self();
        }

        @Override
        protected void preBuild() {
            super.preBuild();
            if (null == object.templateName || object.templateName.isEmpty()) {
                addPreBuildError(PRE_BUILD_TEMPLATE_NAME_NOT_SET, "'template_name' must be set and may not be empty!");
            }
        }
    }

    public static class Builder extends Init<Builder, RenderTemplatePayload> {

        public Builder() {
            super(new RenderTemplatePayload());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
