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

package io.sprucehill.mandrill.data.error;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TemplateMessageError extends MessageError {

    protected static abstract class Init<T extends Init<T,U>, U extends TemplateMessageError> extends MessageError.Init<T,U> {

        private static final Set<String> names;

        static {
            Set<String> namesTmp = new HashSet<String>();
            namesTmp.add("Unknown_Template");
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

    public static class Builder extends Init<Builder,TemplateMessageError> {

        public Builder() {
            super(new TemplateMessageError());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}