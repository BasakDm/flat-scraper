package com.example.basak.springrenew.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
//@Builder
@Table(name = "resources")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
    private long id;

    private String name;

    private String description;

    private String url;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resource")
    private Set<TaskInfoEntity> tasks;

}
