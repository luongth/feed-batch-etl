/*
 * Copyright 2016 Thuan Anh Luong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package solutions.tal.feed;

import solutions.tal.core.ReverseLookupEnumSupport;

/**
 * @author Thuan Luong
 */
public enum FeedType implements ReverseLookupEnumSupport<String, FeedType> {

    EOD ("EOD"),
    DELAYED_EOD ("EOD_D"),
    INTRA_DAY ("Intra");

    private final String label;

    FeedType(String label) {
        this.label = label;
    }

    @Override
    public String value() {
        return this.label;
    }

    public static FeedType fromValue(String value) {
        return EOD.lookup(value).orElseThrow(IllegalArgumentException::new);
    }
}
