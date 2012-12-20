package com.pocketsunited.mandrill.data.error;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MessageError extends Error {

    protected static abstract class Init<T extends Init<T,U>, U extends MessageError> extends Error.Init<T,U> {

        private static final Set<String> names;

        static {
            Set<String> namesTmp = new HashSet<String>();
            namesTmp.add("Invalid_Key");
            namesTmp.add("ValidationError");
            namesTmp.add("GeneralError");
            names = Collections.unmodifiableSet(namesTmp);
        }

        protected Init(U object) {
            super(object);
        }

        @Override
        public T withName(String name) {
            if (names.contains(name)) {
                return super.withName(name);
            }
            throw new IllegalArgumentException("Illegal name for this type of error!");
        }
    }

    public static class Builder extends Init<Builder,MessageError> {

        public Builder() {
            super(new MessageError());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}