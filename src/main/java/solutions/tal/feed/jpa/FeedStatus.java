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

import solutions.tal.feed.FeedType;
import solutions.tal.feed.Region;
import solutions.tal.feed.SourceSystem;
import solutions.tal.feed.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Thuan Luong
 */
@Entity
@Table(name = "pt_feed_status")
public class FeedStatus implements Serializable {

    @Id
    @Column(name = "job_id")
    private String name;

    @Column
    @Convert(converter = FeedTypeConverter.class)
    private FeedType type;

    @Column
    @Convert(converter = StatusConverter.class)
    private Status status;

    @Column
    @Convert(converter = RegionConverter.class)
    private Region region;

    @Column(name = "source_system")
    @Convert(converter = SourceSystemConverter.class)
    private SourceSystem sourceSystem;

    @Column(name = "business_date")
    @Convert(converter = BusinessDateConverter.class)
    private LocalDate businessDate;

    @Column(name = "last_updated", columnDefinition = "DATETIME DEFAULT SYSDATE", insertable = false)
    @Convert(converter = LastUpdatedConverter.class)
    private LocalDateTime lastUpdated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeedType getType() {
        return type;
    }

    public void setType(FeedType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public SourceSystem getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(SourceSystem sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeedStatus{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", businessDate=").append(businessDate);
        sb.append(", lastUpdated=").append(lastUpdated);
        sb.append(", sourceSystem=").append(sourceSystem);
        sb.append(", region=").append(region);
        sb.append('}');
        return sb.toString();
    }
}
