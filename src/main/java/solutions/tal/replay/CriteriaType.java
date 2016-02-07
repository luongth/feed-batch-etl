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
public enum CriteriaType implements ReverseLookupEnumSupport<Integer, CriteriaType> {

    CLIENT_LEDGER (1, "Client Ledger"),
    ACN (2, "ACN"),
    BROKER_LEDGER (3, "Broker Ledger");

    private final int code;

    private final String label;

    CriteriaType(int code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public Integer value() {
        return code;
    }

    public int getCode() {
        return value();
    }

    public String getLabel() {
        return label;
    }

    public static CriteriaType fromCode(int code) {
        return CLIENT_LEDGER.lookup(code).orElseThrow(()->new IllegalArgumentException(String.format("Unsupported code for %s ['%d']", CriteriaType.class.getName(), code)));
    }
}
