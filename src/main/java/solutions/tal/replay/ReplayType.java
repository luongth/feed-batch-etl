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

package solutions.tal.replay;

import solutions.tal.core.ReverseLookupEnumSupport;

/**
 * @author Thuan Luong
 */
public enum ReplayType implements ReverseLookupEnumSupport<Integer, ReplayType> {

    EMIR_FAILED_POSITIONS (1, "Failed Positions"),
    EMIR_AMENDED_POSITIONS (2, "Amended Positions"),
    EMIR_FAILED_TRADES (3, "Failed Trades"),
    EMIR_AMENDED_TRADES (4, "Amended Trades"),
    UC_TRADE (5, "UC Trade"),
    UC_POSITION (6, "UC Position");

    private final int code;

    private final String label;

    ReplayType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return value();
    }

    public String getLabel() {
        return label;
    }

    @Override
    public Integer value() {
        return code;
    }

    public static ReplayType fromCode(int code) {
        return UC_TRADE.lookup(code).orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported code for %s ['%d']", ReplayType.class.getName(), code)));
    }

}
