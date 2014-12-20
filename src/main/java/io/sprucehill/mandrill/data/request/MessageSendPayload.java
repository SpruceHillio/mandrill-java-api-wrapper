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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.sprucehill.mandrill.data.AbstractJsonBase;

/**
 * @author Michael Duergner <michael@sprucehill.io>
 * @author Stephan Wienczny <stephan.wienczny@ybm-deutschland.de>
 */
public class MessageSendPayload extends AbstractPayload {

    @JsonProperty
    protected Message message = new Message();
    @JsonProperty
    protected boolean async = Boolean.FALSE;

    @Override
    public String getPath() {
        return "/messages/send.json";
    }

    public static final class Recipient extends AbstractJsonBase {

        public static enum Type {
            to,cc,bcc
        }

        @JsonProperty
        protected String email;

        @JsonProperty
        protected String name;

        @JsonProperty
        protected Type type = Type.to;

        protected Recipient() {}

        protected Recipient(String email) {
            this.email = email;
        }

        protected Recipient(String email, Type type) {
            this.email = email;
            this.type = type;
        }

        protected Recipient(String email, String name) {
            this(email);
            this.name = name;
        }

        protected Recipient(String email, String name, Type type) {
            this(email);
            this.name = name;
            this.type = type;
        }

        @Override
        public int hashCode() {
            return null == email ? super.hashCode() : email.hashCode();
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o) {
                return false;
            }
            if (!Recipient.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == email ? super.equals(o) : email.equals(((Recipient) o).email);
        }
    }

    public static final class Variable extends AbstractJsonBase {

        @JsonProperty
        protected String name;

        @JsonProperty
        protected String content;

        protected Variable() {
        }

        protected Variable(final String name, final String content) {
            this.name = name;
            this.content = content;
        }

        @Override
        public int hashCode() {
            return null == name ? super.hashCode() : name.hashCode();
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o) {
                return false;
            }
            if (!Variable.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == name ? super.equals(o) : name.equals(((Variable) o).name);
        }
    }

    public static final class RecipientMergeVars extends AbstractJsonBase {

        @JsonProperty(
                value = "rcpt")
        protected String recipient;

        @JsonProperty
        protected List<Variable> vars = new ArrayList<Variable>();

        protected RecipientMergeVars() {
        }

        protected RecipientMergeVars(final String recipient) {
            this.recipient = recipient;
        }

        protected RecipientMergeVars(final String recipient, final List<Variable> vars) {
            this.recipient = recipient;
            this.vars = vars;
        }

        @Override
        public int hashCode() {
            return null == recipient ? super.hashCode() : recipient.hashCode();
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o) {
                return false;
            }

            if (!RecipientMergeVars.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == recipient ? super.equals(o) : recipient.equals(((RecipientMergeVars) o).recipient);
        }
    }

    public static final class RecipientMetadata extends AbstractJsonBase {

        @JsonProperty(
                value = "rcpt")
        protected String recipient;

        @JsonProperty
        protected List<String> values = new ArrayList<String>();

        protected RecipientMetadata() {
        }

        protected RecipientMetadata(final String recipient) {
            this.recipient = recipient;
        }

        protected RecipientMetadata(final String recipient, final List<String> values) {
            this.recipient = recipient;
            this.values = values;
        }

        @Override
        public int hashCode() {
            return null == recipient ? super.hashCode() : recipient.hashCode();
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o) {
                return false;
            }

            if (!RecipientMetadata.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == recipient ? super.equals(o) : recipient.equals(((RecipientMetadata) o).recipient);
        }
    }

    public static final class Attachment extends AbstractJsonBase {

        @JsonProperty
        protected String type;

        @JsonProperty
        protected String name;

        @JsonProperty
        protected byte[] content;

        protected Attachment() {
        }

        protected Attachment(final String type, final String name, final byte[] content) {
            this.type = type;
            this.name = name;
            this.content = content;
        }

        @Override
        public int hashCode() {
            return null == name ? super.hashCode() : name.hashCode();
        }

        @Override
        public boolean equals(final Object o) {
            if (null == o) {
                return false;
            }
            if (!Attachment.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == name ? super.equals(o) : name.equals(((Attachment) o).name);
        }
    }

    public static final class Message extends AbstractJsonBase {

        @JsonProperty
        protected String html;

        @JsonProperty
        protected String text;

        @JsonProperty
        protected String subject;

        @JsonProperty(
                value = "from_email")
        protected String fromEmail;

        @JsonProperty(
                value = "from_name")
        protected String fromName;

        @JsonProperty
        protected List<Recipient> to = new ArrayList<Recipient>();

        @JsonProperty(
                value = "inline_css")
        protected boolean inlineCss = Boolean.FALSE;

        @JsonProperty(
                value = "track_opens")
        protected boolean trackOpens = Boolean.FALSE;

        @JsonProperty(
                value = "track_clicks")
        protected boolean trackClicks = Boolean.FALSE;

        @JsonProperty(
                value = "auto_text")
        protected boolean autoText = Boolean.FALSE;

        @JsonProperty(
                value = "url_strip_qs")
        protected boolean urlStripQS = Boolean.FALSE;

        @JsonProperty(
                value = "preserve_recipients")
        protected boolean preserveRecipients = Boolean.FALSE;

        @JsonProperty(
                value = "bcc_address")
        protected String bccAddress;

        @JsonProperty(
                value = "global_merge_vars")
        protected List<Variable> globalMergeVars = new ArrayList<Variable>();

        @JsonProperty(
                value = "merge_vars")
        protected List<RecipientMergeVars> mergeVars = new ArrayList<RecipientMergeVars>();

        @JsonProperty
        protected List<String> tags = new ArrayList<String>();

        @JsonProperty(
                value = "google_analytics_domains")
        protected List<String> googleAnalyticsDomains = new ArrayList<String>();

        @JsonProperty(
                value = "google_analytics_campaign")
        protected String googleAnalyticsCampaign;

        @JsonProperty
        protected List<String> metadata = new ArrayList<String>();

        @JsonProperty(
                value = "recipient_metadata")
        protected List<RecipientMetadata> recipientMetadata = new ArrayList<RecipientMetadata>();

        @JsonProperty
        protected List<Attachment> attachments = new ArrayList<Attachment>();
    }

    public static abstract class Init<T extends Init<T, U>, U extends MessageSendPayload>
            extends AbstractPayload.Init<T, U>
            implements IWithMergeVarRecipientAwarePayloadBuilder<T> {

        protected Init(U object) {
            super(object);
        }

        public T withHtml(final String html) {
            object.message.html = html;
            return self();
        }

        public T withText(final String text) {
            object.message.text = text;
            return self();
        }

        public T withSubject(final String subject) {
            object.message.subject = subject;
            return self();
        }

        public T withFromEmail(final String fromEmail) {
            object.message.fromEmail = fromEmail;
            return self();
        }

        public boolean hasFromEmail() {
            return null != object.message.fromEmail && !object.message.fromEmail.isEmpty();
        }

        public T withFromName(final String fromName) {
            object.message.fromName = fromName;
            return self();
        }

        public boolean hasFromName() {
            return null != object.message.fromName && !object.message.fromName.isEmpty();
        }

        public T withTo(final String email) {
            return withRecipient(new Recipient(email));
        }

        private T withRecipient(final Recipient recipient) {
            if (!object.message.to.contains(recipient)) {
                object.message.to.add(recipient);
            }
            return self();
        }

        public T withCc(String email) {
            return withRecipient(new Recipient(email, Recipient.Type.cc));
        }

        public T withBcc(String email) {
            return withRecipient(new Recipient(email, Recipient.Type.bcc));
        }

        public T withTo(String email, String name) {
            return withRecipient(new Recipient(email, name));
        }

        public T withCc(String email, String name) {
            return withRecipient(new Recipient(email, name, Recipient.Type.cc));
        }

        public T withBcc(String email, String name) {
            return withRecipient(new Recipient(email, name, Recipient.Type.bcc));
        }

        public T withInlineCss(){
          object.message.inlineCss = Boolean.TRUE;
          return self();
        }

        public T withoutInlineCss() {
            object.message.inlineCss = Boolean.FALSE;
            return self();
        }

        public T withTrackOpens() {
            object.message.trackOpens = Boolean.TRUE;
            return self();
        }

        public T withoutTrackOpens() {
            object.message.trackOpens = Boolean.FALSE;
            return self();
        }

        public T withTrackClicks() {
            object.message.trackClicks = Boolean.TRUE;
            return self();
        }

        public T withoutTrackClicks() {
            object.message.trackClicks = Boolean.FALSE;
            return self();
        }

        public T withAutoText() {
            object.message.autoText = Boolean.TRUE;
            return self();
        }

        public T withoutAutoText() {
            object.message.autoText = Boolean.FALSE;
            return self();
        }

        public T withUrlStripQS() {
            object.message.urlStripQS = Boolean.TRUE;
            return self();
        }

        public T withoutUrlStripQS() {
            object.message.urlStripQS = Boolean.FALSE;
            return self();
        }

        public T withPreserveRecipients() {
            object.message.preserveRecipients = Boolean.TRUE;
            return self();
        }

        public T withoutPreserveRecipients() {
            object.message.preserveRecipients = Boolean.FALSE;
            return self();
        }

        public T withBccAddress(final String bccAddress) {
            object.message.bccAddress = bccAddress;
            return self();
        }

        public T withMergeVar(final String name, final String content) {
            return withGlobalMergeVar(name, content);
        }

        public T withGlobalMergeVar(final String name, final String content) {
            Variable var = new Variable(name, content);
            if (!object.message.globalMergeVars.contains(var)) {
                object.message.globalMergeVars.add(var);
            }
            return self();
        }

        public T withMergeVar(final String recipient, final String name, final String content) {
            RecipientMergeVars mergeVars = new RecipientMergeVars(recipient);
            int index = object.message.mergeVars.indexOf(mergeVars);
            if (-1 != index) {
                mergeVars = object.message.mergeVars.get(index);
            } else {
                object.message.mergeVars.add(mergeVars);
            }
            mergeVars.vars.add(new Variable(name, content));
            return self();
        }

        public T withTag(final String tag) {
            if (!object.message.tags.contains(tag)) {
                object.message.tags.add(tag);
            }
            return self();
        }

        public T withGoogleAnalyticsDomain(final String googleAnalyticsDomain) {
            if (!object.message.googleAnalyticsDomains.contains(googleAnalyticsDomain)) {
                object.message.googleAnalyticsDomains.add(googleAnalyticsDomain);
            }
            return self();
        }

        public T withGoogleAnalyticsCampaign(final String googleAnalyticsCampaign) {
            object.message.googleAnalyticsCampaign = googleAnalyticsCampaign;
            return self();
        }

        public T withMetadata(final String metadata) {
            if (!object.message.metadata.contains(metadata)) {
                object.message.metadata.add(metadata);
            }
            return self();
        }

        public T withRecipientMetadata(final String recipient, final String metadata) {
            RecipientMetadata recipientMetadata = new RecipientMetadata(recipient);
            int index = object.message.recipientMetadata.indexOf(recipientMetadata);
            if (-1 != index) {
                recipientMetadata = object.message.recipientMetadata.get(index);
            } else {
                object.message.recipientMetadata.add(recipientMetadata);
            }
            recipientMetadata.values.add(metadata);
            return self();
        }

        public T withAttachment(final String type, final String name, final byte[] content) {
            Attachment attachment = new Attachment(type, name, content);
            if (!object.message.attachments.contains(attachment)) {
                object.message.attachments.add(attachment);
            }
            return self();
        }

        public T doAsynchronous() {
            object.async = Boolean.TRUE;
            return self();
        }

        public T doSynchronous() {
            object.async = Boolean.FALSE;
            return self();
        }
    }

    public static class Builder extends Init<Builder, MessageSendPayload> {

        public Builder() {
            super(new MessageSendPayload());
        }

        protected Builder(final MessageSendPayload object) {
            super(object);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
