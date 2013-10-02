package com.pocketsunited.mandrill.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pocketsunited.mandrill.data.AbstractJsonBase;

import java.util.ArrayList;
import java.util.List;

public class MessagePayload extends AbstractPayload {

    @Override
    public String getPath() {
        return "/messages/send.json";
    }

    public static final class Recipient extends AbstractJsonBase {

        @JsonProperty
        protected String email;

        @JsonProperty
        protected String name;

        protected Recipient() {}

        protected Recipient(String email) {
            this.email = email;
        }

        protected Recipient(String email, String name) {
            this(email);
            this.name = name;
        }

        @Override
        public int hashCode() {
            return null == email ? super.hashCode() : email.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) {
                return false;
            }
            if (!Recipient.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == email ? super.equals(o) : email.equals(((Recipient)o).email);
        }
    }

    public static final class Variable extends AbstractJsonBase {

        @JsonProperty
        protected String name;

        @JsonProperty
        protected String content;

        protected Variable() {}

        protected Variable(String name, String content) {
            this.name = name;
            this.content = content;
        }

        @Override
        public int hashCode() {
            return null == name ? super.hashCode() : name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) {
                return false;
            }
            if (!Variable.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == name ? super.equals(o) : name.equals(((Variable)o).name);
        }
    }

    public static final class RecipientMergeVars extends AbstractJsonBase {

        @JsonProperty(
                value = "rcpt")
        protected String recipient;

        @JsonProperty
        protected List<Variable> vars = new ArrayList<Variable>();

        protected RecipientMergeVars() {}

        protected RecipientMergeVars(String recipient) {
            this.recipient = recipient;
        }

        protected RecipientMergeVars(String recipient, List<Variable> vars) {
            this.recipient = recipient;
            this.vars = vars;
        }

        @Override
        public int hashCode() {
            return null == recipient ? super.hashCode() : recipient.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) {
                return false;
            }

            if (!RecipientMergeVars.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == recipient ? super.equals(o) : recipient.equals(((RecipientMergeVars)o).recipient);
        }
    }

    public static final class RecipientMetadata extends AbstractJsonBase {

        @JsonProperty(
                value = "rcpt")
        protected String recipient;

        @JsonProperty
        protected List<String> values = new ArrayList<String>();

        protected RecipientMetadata() {}

        protected RecipientMetadata(String recipient) {
            this.recipient = recipient;
        }

        protected RecipientMetadata(String recipient, List<String> values) {
            this.recipient = recipient;
            this.values = values;
        }

        @Override
        public int hashCode() {
            return null == recipient ? super.hashCode() : recipient.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) {
                return false;
            }

            if (!RecipientMetadata.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == recipient ? super.equals(o) : recipient.equals(((RecipientMetadata)o).recipient);
        }
    }

    public static final class Attachment extends AbstractJsonBase {

        @JsonProperty
        protected String type;

        @JsonProperty
        protected String name;

        @JsonProperty
        protected String content;

        protected Attachment() {}

        protected Attachment(String type, String name, String content) {
            this.type = type;
            this.name = name;
            this.content = content;
        }

        @Override
        public int hashCode() {
            return null == name ? super.hashCode() : name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) {
                return false;
            }
            if (!Attachment.class.isAssignableFrom(o.getClass())) {
                return false;
            }

            return null == name ? super.equals(o) : name.equals(((Attachment)o).name);
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

    @JsonProperty
    protected Message message = new Message();

    @JsonProperty
    protected boolean async = Boolean.FALSE;

    public static abstract class Init<T extends Init<T,U>, U extends MessagePayload> extends AbstractPayload.Init<T,U> {

        protected Init(U object) {
            super(object);
        }

        public T withHtml(String html) {
            object.message.html = html;
            return self();
        }

        public T withText(String text) {
            object.message.text = text;
            return self();
        }

        public T withSubject(String subject) {
            object.message.subject = subject;
            return self();
        }

        public T withFromEmail(String fromEmail) {
            object.message.fromEmail = fromEmail;
        return self();
        }

        public boolean hasFromEmail() {
            return null != object.message.fromEmail && !object.message.fromEmail.isEmpty();
        }

        public T withFromName(String fromName) {
            object.message.fromName = fromName;
            return self();
        }

        public boolean hasFromName() {
            return null != object.message.fromName && !object.message.fromName.isEmpty();
        }

        private T withRecipient(Recipient recipient) {
            if (!object.message.to.contains(recipient)) {
                object.message.to.add(recipient);
            }
            return self();
        }

        public T withTo(String email) {
            return withRecipient(new Recipient(email));
        }

        public T withTo(String email, String name) {
            return withRecipient(new Recipient(email, name));
        }

        public T withInlineCss(){
          object.message.inlineCss = Boolean.TRUE;
          return self();
        }

        public T withoutInlineCss(){
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

        public T withBccAddress(String bccAddress){
            object.message.bccAddress = bccAddress;
            return self();
        }

        public T withGlobalMergeVar(String name, String content) {
            Variable var = new Variable(name,content);
            if (!object.message.globalMergeVars.contains(var)) {
                object.message.globalMergeVars.add(var);
            }
            return self();
        }

        public T withMergeVar(String recipient, String name, String content) {
            RecipientMergeVars mergeVars = new RecipientMergeVars(recipient);
            int index = object.message.mergeVars.indexOf(mergeVars);
            if (-1 != index) {
                mergeVars = object.message.mergeVars.get(index);
            }
            else {
                object.message.mergeVars.add(mergeVars);
            }
            mergeVars.vars.add(new Variable(name,content));
            return self();
        }

        public T withTag(String tag) {
            if (!object.message.tags.contains(tag)) {
                object.message.tags.add(tag);
            }
            return self();
        }

        public T withGoogleAnalyticsDomain(String googleAnalyticsDomain) {
            if (!object.message.googleAnalyticsDomains.contains(googleAnalyticsDomain)) {
                object.message.googleAnalyticsDomains.add(googleAnalyticsDomain);
            }
            return self();
        }

        public T withGoogleAnalyticsCampaign(String googleAnalyticsCampaign) {
            object.message.googleAnalyticsCampaign = googleAnalyticsCampaign;
            return self();
        }

        public T withMetadata(String metadata) {
            if (!object.message.metadata.contains(metadata)) {
                object.message.metadata.add(metadata);
            }
            return self();
        }

        public T withRecipientMetadata(String recipient, String metadata) {
            RecipientMetadata recipientMetadata = new RecipientMetadata(recipient);
            int index = object.message.recipientMetadata.indexOf(recipientMetadata);
            if (-1 != index) {
                recipientMetadata = object.message.recipientMetadata.get(index);
            }
            else {
                object.message.recipientMetadata.add(recipientMetadata);
            }
            recipientMetadata.values.add(metadata);
            return self();
        }

        public T withAttachment(String type, String name, String content) {
            Attachment attachment = new Attachment(type,name,content);
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

    public static class Builder extends Init<Builder,MessagePayload> {

        public Builder() {
            super(new MessagePayload());
        }

        protected Builder(MessagePayload object) {
            super(object);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}