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

package solutions.tal.feed.jpa;

import solutions.tal.feed.SourceSystem;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Thuan Luong
 */
@Converter
public class SourceSystemConverter implements AttributeConverter<SourceSystem, String> {

    @Override
    public String convertToDatabaseColumn(SourceSystem sourceSystem) {
        return sourceSystem != null ? sourceSystem.name() : null;
    }

    @Override
    public SourceSystem convertToEntityAttribute(String value) {
        return SourceSystem.valueOf(value);
    }
}
