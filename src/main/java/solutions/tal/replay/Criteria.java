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

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

/**
 * @author Thuan Luong
 */
public class Criteria implements Serializable {

    private final Map<CriteriaType, Set<String>> criterionByType;

    public Criteria(Set<Criterion> criteria) {

        this.criterionByType = criteria.stream()
                .collect(groupingBy(Criterion::getCriteriaType, TreeMap::new, mapping(Criterion::getValue, toSet())));
    }

    public Set<String> getCriteria(CriteriaType type) {
        return criterionByType.get(type);
    }
}
