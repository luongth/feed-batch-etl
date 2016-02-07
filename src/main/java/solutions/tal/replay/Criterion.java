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

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Thuan Luong
 */
@Entity
@Table(name = "REPLAY_CRITERIA")
public class Criterion implements Serializable {

    @Id
    @GeneratedValue(generator = "entityIdGenerator")
    @SequenceGenerator(name = "entityIdGenerator", sequenceName = "REPLAY_CRITERIA_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "CRITERIA_TYPE_ID")
    @Convert(converter = CriteriaTypeConverter.class)
    private CriteriaType criteriaType;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "REPLAY_DEFINITION_ID")
    private ReplayDefinition replayDefinition;

    public Long getId() {
        return id;
    }

    public CriteriaType getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(CriteriaType criteriaType) {
        this.criteriaType = criteriaType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ReplayDefinition getReplayDefinition() {
        return replayDefinition;
    }

    public void setReplayDefinition(ReplayDefinition replayDefinition) {
        this.replayDefinition = replayDefinition;
    }
}
