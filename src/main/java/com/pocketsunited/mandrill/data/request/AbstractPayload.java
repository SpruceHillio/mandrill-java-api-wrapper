package com.pocketsunited.mandrill.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pocketsunited.mandrill.data.AbstractJsonBase;
import com.pocketsunited.mandrill.data.error.PreBuildError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPayload extends AbstractJsonBase {

    public static final String PRE_BUILD_KEY_NOT_SET = "KET_NOT_SET";

    public abstract String getPath();

    @JsonProperty
    protected String key;

    protected static abstract class Init<T extends Init<T, U>, U extends AbstractPayload> {

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