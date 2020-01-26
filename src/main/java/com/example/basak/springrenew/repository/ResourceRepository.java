package com.example.basak.springrenew.repository;

import com.example.basak.springrenew.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
