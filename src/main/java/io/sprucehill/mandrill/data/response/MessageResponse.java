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

package io.sprucehill.mandrill.data.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jersey.repackaged.com.google.common.base.Objects;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class MessageResponse extends Response {

    @JsonProperty
    protected String email;
    @JsonProperty
    protected Status status;
    @JsonProperty("reject_reason")
    protected String rejectReason;

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("email", email).add("status", status)
                .add("rejectReaseon", rejectReason).toString();
    }

    public static enum Status {
        SENT, QUEUED, REJECTED, INVALID;

        @JsonCreator
        public static Status parse(String value) {
            return valueOf(value.toUpperCase());
        }
    }
}