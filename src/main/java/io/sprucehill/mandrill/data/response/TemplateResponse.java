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

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jersey.repackaged.com.google.common.base.Objects;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class TemplateResponse extends Response {

    @JsonProperty
    private String slug;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<String> labels;

    @JsonProperty
    private String code;

    @JsonProperty
    private String subject;

    @JsonProperty("from_email")
    private String fromEmail;

    @JsonProperty("from_name")
    private String fromName;

    @JsonProperty
    private String text;

    @JsonProperty("publish_name")
    private String publishName;

    @JsonProperty("publish_code")
    private String publishCode;

    @JsonProperty("publish_subject")
    private String publishSubject;

    @JsonProperty("publish_from_email")
    private String publishFromEmail;

    @JsonProperty("publish_from_name")
    private String publishFromName;

    @JsonProperty("publish_text")
    private String publishText;

    @JsonProperty("published_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
    private Date publishedAt;

    @JsonProperty("created_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
    private Date createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT")
    private Date updatedAt;

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getCode() {
        return code;
    }

    public String getSubject() {
        return subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public String getText() {
        return text;
    }

    public String getPublishName() {
        return publishName;
    }

    public String getPublishCode() {
        return publishCode;
    }

    public String getPublishSubject() {
        return publishSubject;
    }

    public String getPublishFromEmail() {
        return publishFromEmail;
    }

    public String getPublishFromName() {
        return publishFromName;
    }

    public String getPublishText() {
        return publishText;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("slug", slug).add("name", name).add("label", labels)
                .add("code", code).add("subject", subject).add("fromEmail", fromEmail)
                .add("fromName", fromName).add("text", text).add("publishName", publishName)
                .add("publishCode", publishCode).add("publishSubject", publishSubject)
                .add("publishFromEmail", publishFromEmail).add("publishFromName", publishFromName)
                .add("publish_text", publishText).add("published_at", publishedAt)
                .add("created_at", createdAt).add("updated_at", updatedAt).toString();
    }
}