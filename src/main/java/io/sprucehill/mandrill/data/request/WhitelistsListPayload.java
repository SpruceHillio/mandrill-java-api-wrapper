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

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class WhitelistsListPayload extends AbstractWhitelistsPayload {
    @Override
    public String getPath() {
        return "/whitelists/list.json";
    }

    public static abstract class Init<T extends Init<T, U>, U extends WhitelistsListPayload>
            extends AbstractWhitelistsPayload.Init<T, U> {

        protected Init(final U object) {
            super(object);
        }
    }

    public static class Builder extends Init<Builder, WhitelistsListPayload> {

        public Builder() {
            super(new WhitelistsListPayload());
        }

        protected Builder(final WhitelistsListPayload object) {
            super(object);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
