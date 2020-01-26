package com.example.basak.springrenew.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tasks_info")
public class TaskInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_info_id")
    private long id;

    private int period;

    @CreatedDate
    private Date createdTime;

    private boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resource_id", nullable = false)
    private ResourceEntity resource;

}

