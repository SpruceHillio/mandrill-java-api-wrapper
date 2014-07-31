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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.sprucehill.mandrill.data.AbstractJsonBase;
import io.sprucehill.mandrill.data.error.PreBuildError;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public abstract class AbstractRejectsPayload extends AbstractPayload {

    @JsonProperty
    protected String email;

    @JsonProperty
    protected String subaccount;

    public abstract String getPath();

    public static abstract class Init<T extends Init<T, U>, U extends AbstractRejectsPayload>
            extends AbstractPayload.Init<T, U> {

        protected Init(U object) {
            super(object);
        }

        public T withEmail(final String email) {
            object.email = email;
            return self();
        }

        public T withSubaccount(final String subaccount) {
            object.subaccount = subaccount;
            return self();
        }

        protected abstract T self();

        public boolean hasEmail() {
            return null != object.email && !object.email.isEmpty();
        }

        public boolean hasSubaccount() {
            return null != object.subaccount && !object.subaccount.isEmpty();
        }
    }

    public static abstract class Builder extends Init<Builder, AbstractRejectsPayload> {

        protected Builder(final AbstractRejectsPayload object) {
            super(object);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
