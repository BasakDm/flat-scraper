package com.example.basak.springrenew.repository;

import com.example.basak.springrenew.model.TaskInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskInfoRepository extends JpaRepository<TaskInfo, Long> {
}
