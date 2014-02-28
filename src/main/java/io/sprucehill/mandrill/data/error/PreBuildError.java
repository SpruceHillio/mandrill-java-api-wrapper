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

package io.sprucehill.mandrill.data.error;

import java.util.Collections;
import java.util.Map;

/**
 * @author Michael Duergner <michael@sprucehill.io>
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
