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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.mandrill.data.AbstractJsonBase;
import io.sprucehill.mandrill.data.error.PreBuildError;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public abstract class AbstractPayload extends AbstractJsonBase {

    public static final String PRE_BUILD_KEY_NOT_SET = "KET_NOT_SET";

    public abstract String getPath();

    @JsonProperty
    protected String key;

    public static abstract class Init<T extends Init<T, U>, U extends AbstractPayload> {

        private Map<String,String> preBuildErrors = new HashMap<String, String>();

        protected U object;

        protected abstract T self();

        protected Init(U object) {
            this.object = object;
        }

        protected void postInit() {
        }

        /**
         * Override this method to add additional pre build validation to your payload object;
         *
         * NOTE: always call super.preBuild() as first statement in you own implementation!
         */
        protected void preBuild() {
            if (null == object.key || object.key.isEmpty()) {
                addPreBuildError(PRE_BUILD_KEY_NOT_SET,"'key' must be set and may not be empty!");
            }
        }

        /**
         * Use this method to add a string pair indicating a single pre build validation error
         *
         * @param preBuildErrorKey
         * @param preBuildErrorMessage
         */
        protected final void addPreBuildError(String preBuildErrorKey, String preBuildErrorMessage) {
            preBuildErrors.put(preBuildErrorKey,preBuildErrorMessage);
        }

        public T withKey(String key) {
            object.key = key;
            return self();
        }

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
    }

    public static abstract class Builder extends Init<Builder,AbstractPayload> {

        protected Builder(AbstractPayload object) {
            super(object);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}