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
import java.util.Set;

/**
 * @author Thuan Luong
 */
@Entity
@Table(name = "REPLAY_DEFINITIONS")
public class ReplayDefinition implements Serializable {

    @Id
    @GeneratedValue(generator = "entityIdGenerator", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "entityIdGenerator", sequenceName = "REPLAY_DEFINITION_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String description;

    @Column(name = "REPLAY_TYPE_ID")
    @Convert(converter = ReplayTypeConverter.class)
    private ReplayType type;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "replayDefinition")
    @Access(AccessType.PROPERTY)
    private Set<Criterion> criteria;

    private Criteria replayCriteria;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReplayType getType() {
        return type;
    }

    public void setType(ReplayType type) {
        this.type = type;
    }

    void setCriteria(Set<Criterion> criteria) {
        this.criteria = criteria;
        this.replayCriteria = new Criteria(criteria);
    }

    public Criteria getReplayCriteria() {
        return this.replayCriteria;
    }
}
