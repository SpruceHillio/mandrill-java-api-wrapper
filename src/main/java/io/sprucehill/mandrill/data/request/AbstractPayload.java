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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.sprucehill.mandrill.data.AbstractJsonBase;
import io.sprucehill.mandrill.data.error.PreBuildError;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public abstract class AbstractPayload extends AbstractJsonBase {

    public static final String PRE_BUILD_KEY_NOT_SET = "KET_NOT_SET";
    @JsonProperty
    protected String key;

    public abstract String getPath();

    public static abstract class Init<T extends Init<T, U>, U extends AbstractPayload> {

        protected U object;
        private Map<String, String> preBuildErrors = new HashMap<String, String>();

        protected Init(U object) {
            this.object = object;
        }

        protected void postInit() {
        }

        public T withKey(final String key) {
            object.key = key;
            return self();
        }

        protected abstract T self();

        public boolean hasKey() {
            return null != object.key && !object.key.isEmpty();
        }

        public U build() throws PreBuildError {
            preBuild();
            if (0 < preBuildErrors.size()) {
                throw new PreBuildError(preBuildErrors);
            }
            return object;
        }

        /**
         * Override this method to add additional pre build validation to your payload object;
         * <p/>
         * NOTE: always call super.preBuild() as first statement in you own implementation!
         */
        protected void preBuild() {
            if (null == object.key || object.key.isEmpty()) {
                addPreBuildError(PRE_BUILD_KEY_NOT_SET, "'key' must be set and may not be empty!");
            }
        }

        /**
         * Use this method to add a string pair indicating a single pre build validation error
         *
         * @param preBuildErrorKey
         * @param preBuildErrorMessage
         */
        protected final void addPreBuildError(String preBuildErrorKey, String preBuildErrorMessage) {
            preBuildErrors.put(preBuildErrorKey, preBuildErrorMessage);
        }
    }

    public static abstract class Builder extends Init<Builder, AbstractPayload> {

        protected Builder(final AbstractPayload object) {
            super(object);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
