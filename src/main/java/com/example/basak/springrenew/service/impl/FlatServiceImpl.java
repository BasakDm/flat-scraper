package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.TaskInfo;
import com.example.basak.springrenew.repository.TaskInfoRepository;
import com.example.basak.springrenew.service.FlatService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class FlatServiceImpl implements FlatService {

    private final TaskInfoRepository taskInfoRepository;

    public FlatServiceImpl(TaskInfoRepository taskInfoRepository) {
        this.taskInfoRepository = taskInfoRepository;
    }

    @Override
    public void startForumScrapeTask(TaskInfo taskInfoParams) {
//        saveTaskParams(taskInfoParams);
//
//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(
//                new ScrapeForumTask(taskInfoParams.getEmail(), taskInfoParams.getUserName()),
//                0,
//                taskInfoParams.getPeriod(),
//                TimeUnit.MINUTES);
    }

    @Override
    public void saveTaskParams(TaskInfo taskInfoParams) {
        taskInfoRepository.save(taskInfoParams);
    }

    @Override
    public List<TaskInfo> getAllTaskParams() {
        return taskInfoRepository.findAll();
    }

}
