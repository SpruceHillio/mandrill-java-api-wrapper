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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.sprucehill.mandrill.data.AbstractJsonBase;

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public abstract class TemplatePayload extends AbstractPayload {

    public static final String PRE_BUILD_TEMPLATE_NAME_NOT_SET = "TEMPLATE_NAME_NOT_SET";

    @JsonProperty(value = "name")
    protected String name;

    public static final class Variable extends AbstractJsonBase {

        @JsonProperty
        protected String name;

        @JsonProperty
        protected String content;

        protected Variable() {
        }

        protected Variable(final String name, final String content) {
            this.name = name;
            this.content = content;
        }

        @Override
        public int hashCode() {
            return null == name ? super.hashCode() : name.hashCode();
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o) {
                return false;
            }
            if (!Variable.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == name ? super.equals(o) : name.equals(((Variable) o).name);
        }
    }

    protected static abstract class Init<T extends Init<T, U>, U extends TemplatePayload> extends AbstractPayload.Init<T, U> implements IWithNamePayloadBuilder<T> {

        protected Init(U object) {
            super(object);
        }

        public T withName(final String name) {
            object.name = name;
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
