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

/**
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public class TemplateListPayload extends LabelPayload {
    @Override
    public String getPath() {
        return "/templates/list.json";
    }

    public static class Builder extends Init<Builder, TemplateListPayload> {

        public Builder() {
            super(new TemplateListPayload());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
