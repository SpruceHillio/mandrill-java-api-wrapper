package com.pocketsunited.mandrill.data.request;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public interface IWithMergeVarPayloadBuilder<T> {

    T withMergeVar(String name, String content);
}
