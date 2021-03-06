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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TemplateMessagePayload extends MessagePayload {

    public static final String PRE_BUILD_TEMPLATE_NAME_NOT_SET = "TEMPLATE_NAME_NOT_SET";

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

    protected static abstract class Init<T extends Init<T,U>, U extends TemplateMessagePayload> extends MessagePayload.Init<T,U> implements IWithTemplateNamePayloadBuilder<T>, IWithTemplateContentPayloadBuilder<T> {

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

        @Override
        protected void preBuild() {
            super.preBuild();
            if (null == object.templateName || object.templateName.isEmpty()) {
                addPreBuildError(PRE_BUILD_TEMPLATE_NAME_NOT_SET,"'template_name' must be set and may not be empty!");
            }
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
