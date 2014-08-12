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

/**
 *
 */
public class TemplateUpdatePayload extends TemplateAddOrUpdatePayload {
    @Override
    public String getPath() {
        return "/templates/update.json";
    }

    public static class Builder extends Init<Builder, TemplateUpdatePayload> {

        public Builder() {
            super(new TemplateUpdatePayload());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}