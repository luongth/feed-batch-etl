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

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import solutions.tal.datasource.H2DataSourceConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Thuan Luong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = {ReplayDefinitionTests.class, H2DataSourceConfiguration.class})
@EntityScan(basePackages = "solutions.tal.replay")
@EnableTransactionManagement
@Transactional
public class ReplayDefinitionTests {

    @PersistenceContext
    private EntityManager em;

    @BeforeClass
    public static void configureEnvironment() {
        System.setProperty("spring.profiles.active", "H2");
    }

    @Test
    public void find_replay_definition() {
        ReplayDefinition replayDefinition = em.find(ReplayDefinition.class, 1L);
        assertThat(replayDefinition, is(notNullValue()));
        assertThat(replayDefinition.getId(), is(notNullValue()));
        assertThat(replayDefinition.getDescription(), is("replay definition 1"));
        assertThat(replayDefinition.getType(), is(ReplayType.UC_TRADE));

        //Set<Criterion> criteria = replayDefinition.getCriteria();
        //assertThat(criteria, is(notNullValue()));
        //assertThat(criteria.size(), is(1));
    }

    @Test
    public void save_criteria() {
        Criterion criterion = new Criterion();
        criterion.setCriteriaType(CriteriaType.CLIENT_LEDGER);
        criterion.setValue("CL2424");
        Criterion saved = em.merge(criterion);
        assertThat(saved, is(notNullValue()));
        assertThat(saved.getId(), is(notNullValue()));
    }

    @Test
    public void find_criteria() {
        Criterion criterion = this.em.find(Criterion.class, 1L);
        assertThat(criterion, is(notNullValue()));
        assertThat(criterion.getCriteriaType(), is(CriteriaType.ACN));
        assertThat(criterion.getValue(), is("2420"));
    }

}
