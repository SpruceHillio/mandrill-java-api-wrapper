package com.pocketsunited.mandrill.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pocketsunited.mandrill.data.AbstractJsonBase;

public abstract class AbstractPayload extends AbstractJsonBase {

    public abstract String getPath();

    @JsonProperty
    protected String key;

    protected static abstract class Init<T extends Init<T, U>, U extends AbstractPayload> {

        protected U object;

        protected abstract T self();

        protected Init(U object) {
            this.object = object;
        }

        protected void postInit() {
        }

        protected void preBuild() {
        }

        public T withKey(String key) {
            object.key = key;
            return self();
        }

        public U build() {
            preBuild();
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