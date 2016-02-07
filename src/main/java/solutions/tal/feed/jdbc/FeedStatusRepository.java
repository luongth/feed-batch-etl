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

/**
 * @author Thuan Luong
 */
public interface FeedStatusRepository {

    FeedStatus findOne(String name);

    FeedStatus save(FeedStatus feedStatus);

    FeedStatus start(String name);

    FeedStatus finish(String name);

    FeedStatus fail(String name);

}
