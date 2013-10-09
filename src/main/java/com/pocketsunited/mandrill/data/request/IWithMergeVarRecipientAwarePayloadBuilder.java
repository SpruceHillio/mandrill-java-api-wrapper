package com.pocketsunited.mandrill.data.request;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public interface IWithMergeVarRecipientAwarePayloadBuilder<T> extends IWithMergeVarPayloadBuilder<T> {

    T withMergeVar(String recipient, String name, String content);
}
