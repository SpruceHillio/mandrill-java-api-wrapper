/*
Copyright 2013-2014 SpruceHill.io GmbH 2014 Stephan Wienczny

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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public abstract class TemplateAddOrUpdatePayload extends TemplatePayload {

    public static final String PRE_BUILD_TEMPLATE_NAME_NOT_SET = "TEMPLATE_NAME_NOT_SET";
    @JsonProperty(value = "from_email")
    protected String fromEmail;
    @JsonProperty(value = "from_name")
    protected String fromName;
    @JsonProperty(value = "subject")
    protected String subject;
    @JsonProperty(value = "code")
    protected String code;
    @JsonProperty(value = "text")
    protected String text;
    @JsonProperty(value = "publish")
    protected boolean publish;
    @JsonProperty(value = "labels")
    protected List<String> labels;

    protected static abstract class Init<T extends Init<T, U>, U extends TemplateAddOrUpdatePayload> extends TemplatePayload.Init<T, U> implements IWithFromPayloadBuilder<T> {

        protected Init(U object) {
            super(object);
        }

        public T withFromEmail(String fromEmail) {
            object.fromEmail = fromEmail;
            return self();
        }

        public T withFromName(String name) {
            object.fromName = name;
            return self();
        }

        public T withSubject(String subject) {
            object.subject = subject;
            return self();
        }

        public T withCode(String code) {
            object.code = code;
            return self();
        }

        public T withText(String text) {
            object.text = text;
            return self();
        }

        public T withPublish(boolean publish) {
            object.publish = publish;
            return self();
        }

        public T withLabel(String label) {
            if (!object.labels.contains(label)) {
                object.labels.add(label);
            }
            return self();
        }

        @Override
        protected void preBuild() {
            super.preBuild();
            if (null == object.name || object.name.isEmpty()) {
                addPreBuildError(PRE_BUILD_TEMPLATE_NAME_NOT_SET, "'template_name' must be set and may not be empty!");
            }
        }
    }
}
