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

import solutions.tal.feed.FeedType;
import solutions.tal.feed.Region;
import solutions.tal.feed.SourceSystem;
import solutions.tal.feed.Status;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Thuan Luong
 */
public class FeedStatus implements Serializable {

    private final String name;

    private final SourceSystem sourceSystem;

    private final Region region;

    private final FeedType feedType;

    private Status status;

    private LocalDate businessDate;

    public FeedStatus(String name, SourceSystem sourceSystem, Region region, FeedType feedType) {
        this.name = name;
        this.sourceSystem = sourceSystem;
        this.region = region;
        this.feedType = feedType;
    }

    public String getName() {
        return name;
    }

    public SourceSystem getSourceSystem() {
        return sourceSystem;
    }

    public Region getRegion() {
        return region;
    }

    public FeedType getFeedType() {
        return feedType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeedStatus{");
        sb.append("name='").append(name).append('\'');
        sb.append(", sourceSystem=").append(sourceSystem);
        sb.append(", region=").append(region);
        sb.append(", feedType=").append(feedType);
        sb.append(", status=").append(status);
        sb.append(", businessDate=").append(businessDate);
        sb.append('}');
        return sb.toString();
    }
}
