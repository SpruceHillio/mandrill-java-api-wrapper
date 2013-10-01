package com.pocketsunited.mandrill.data.error;

import java.util.Collections;
import java.util.Map;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public class PreBuildError extends Exception {

    private Map<String,String> preBuildErrors;

    public PreBuildError(Map<String,String> preBuildErrors) {
        super(concatPreBuildErrors(preBuildErrors));
        this.preBuildErrors = Collections.unmodifiableMap(preBuildErrors);
    }

    public Map<String,String> getPreBuildErrors() {
        return preBuildErrors;
    }

    private static String concatPreBuildErrors(Map<String,String> preBuildErrors) {
        StringBuilder builder = null;
        for (Map.Entry<String,String> preBuildError : preBuildErrors.entrySet()) {
            if (null == builder) {
                builder = new StringBuilder();
            }
            else {
                builder.append(", ");
            }
            builder.append(preBuildError.getKey());
        }
        return null == builder ? "" : builder.toString();
    }
}
