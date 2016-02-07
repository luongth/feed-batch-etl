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

package solutions.tal.feed.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Thuan Luong
 */
public class JdbcFeedStatusRepository implements FeedStatusRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcFeedStatusRepository(@Qualifier("ptDataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public FeedStatus findOne(String name) {

        return null;
    }

    @Override
    public FeedStatus save(FeedStatus feedStatus) {
        return null;
    }

    @Override
    public FeedStatus start(String name) {
        FeedStatus feed = findOne(name);
//        if (feed != null && feed.canStart()) {
//
//        }
        return null;
    }

    @Override
    public FeedStatus finish(String name) {
        return null;
    }

    @Override
    public FeedStatus fail(String name) {
        return null;
    }
}
