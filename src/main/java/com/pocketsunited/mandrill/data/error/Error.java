package com.pocketsunited.mandrill.data.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        creatorVisibility = JsonAutoDetect.Visibility.NONE,
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(
        ignoreUnknown = true)
@JsonInclude(
        value = JsonInclude.Include.NON_EMPTY)
public class Error extends java.lang.Error {

    @JsonProperty
    protected String status;

    @JsonProperty
    protected Integer code;

    @JsonProperty
    protected String name;

    @JsonProperty
    protected String message;

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    protected static abstract class Init<T extends Init<T, U>, U extends Error> {

        protected U object;

        protected Init(U object) {
            this.object = object;
        }

        protected abstract T self();


        protected void postInit() {
        }

        protected void preBuild() {
        }

        public T withStatus(String status) {
            object.status = status;
            return self();
        }

        public T withCode(Integer code) {
            object.code = code;
            return self();
        }

        public T withName(String name) {
            object.name = name;
            return self();
        }

        public T withMessage(String message) {
            object.message = message;
            return self();
        }

        public U build() {
            preBuild();
            return object;
        }
    }

    public static class Builder extends Init<Builder,Error> {

        public Builder() {
            super(new Error());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}