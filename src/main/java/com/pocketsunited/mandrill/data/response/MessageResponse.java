package com.pocketsunited.mandrill.data.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse extends Response {

    public static enum Status {
        SENT,QUEUED,REJECTED,INVALID;

        @JsonCreator
        public static Status parse(String value) {
            return valueOf(value.toUpperCase());
        }
    }

    @JsonProperty
    private String email;

    @JsonProperty
    private Status status;

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new StringBuilder("MessageResponse [email: ").
                append(email).
                append(", status: ").
                append(status).
                append("]").
                toString();
    }
}