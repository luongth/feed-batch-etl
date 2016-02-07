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

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Thuan Luong
 */
public class CriteriaTests {

    @Test
    public void verify_criteria_values_sorted() {

        ImmutableSet<Criterion> criterionSet = ImmutableSet.of(
                buildCriterion(CriteriaType.CLIENT_LEDGER, "CL2424"),
                buildCriterion(CriteriaType.CLIENT_LEDGER, "CL4545"),
                buildCriterion(CriteriaType.CLIENT_LEDGER, "CL1234"),
                buildCriterion(CriteriaType.BROKER_LEDGER, "BLAHH"),
                buildCriterion(CriteriaType.ACN, "2420"),
                buildCriterion(CriteriaType.ACN, "E456"),
                buildCriterion(CriteriaType.BROKER_LEDGER, "RLLDD"));

        Criteria criteria = new Criteria(criterionSet);

        Set<String> clientLedgers = criteria.getCriteria(CriteriaType.CLIENT_LEDGER);
        assertThat(clientLedgers.size(), is(3));
        Iterator<String> clientLedgerIterator = clientLedgers.iterator();
        assertThat(clientLedgerIterator.next(), is("CL1234"));
        assertThat(clientLedgerIterator.next(), is("CL2424"));
        assertThat(clientLedgerIterator.next(), is("CL4545"));

        Set<String> acns = criteria.getCriteria(CriteriaType.ACN);
        assertThat(acns.size(), is(2));
        Iterator<String> acnIterator = acns.iterator();
        assertThat(acnIterator.next(), is("E456"));
        assertThat(acnIterator.next(), is("2420"));


    }

    private Criterion buildCriterion(CriteriaType criteriaType, String value) {
        Criterion criterion = new Criterion();
        criterion.setCriteriaType(criteriaType);
        criterion.setValue(value);
        return criterion;
    }
}
