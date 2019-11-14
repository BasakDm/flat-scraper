package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.TaskInfo;
import com.example.basak.springrenew.repository.TaskInfoRepository;
import com.example.basak.springrenew.service.TaskInfoService;
import org.springframework.stereotype.Service;

@Service
public class TaskInfoServiceImpl implements TaskInfoService {

    private final TaskInfoRepository taskInfoRepository;

    public TaskInfoServiceImpl(TaskInfoRepository taskInfoRepository) {
        this.taskInfoRepository = taskInfoRepository;
    }

    @Override
    public void saveTaskInfo(TaskInfo taskInfo) {
        taskInfoRepository.save(taskInfo);
    }

}
