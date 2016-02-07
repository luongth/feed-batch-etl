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

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import solutions.tal.datasource.H2DataSourceConfiguration;
import solutions.tal.feed.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * @author Thuan Luong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = {FeedStatusRepositoryTests.class, H2DataSourceConfiguration.class})
@EntityScan(basePackages = "solutions.tal.feed")
@EnableTransactionManagement
@Transactional
public class FeedStatusRepositoryTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedStatusRepositoryTests.class);

    @Autowired
    private JpaFeedStatusRepository feedStatusRepository;

    @BeforeClass
    public static void configureEnvironment() {
        System.setProperty("spring.profiles.active", "H2");
    }

    @Test
    public void find_feed_status() {
        FeedStatus feedStatus = feedStatusRepository.findOne("pt-eu-arc-dsl-trade");
        assertThat(feedStatus, is(notNullValue()));
        assertThat(feedStatus.getName(), is("pt-eu-arc-dsl-trade"));
        assertThat(feedStatus.getStatus(), CoreMatchers.is(Status.FINISHED));
        assertThat(feedStatus.getType(), CoreMatchers.is(FeedType.DELAYED_EOD));
        assertThat(feedStatus.getBusinessDate(), is(LocalDate.parse("2016-01-25")));
        assertThat(feedStatus.getSourceSystem(), is(SourceSystem.ARC));
        assertThat(feedStatus.getRegion(), is(Region.EU));
    }

    @Test
    public void update_feed_status() {
        FeedStatus feedStatus = feedStatusRepository.findOne("pt-eu-arc-dsl-trade");
        LOGGER.info("Before: " + feedStatus);

        feedStatus.setStatus(Status.STARTED);
        feedStatus.setLastUpdated(LocalDateTime.now());
        FeedStatus updated = feedStatusRepository.save(feedStatus);

        LOGGER.info("After: " + updated);
    }


}
