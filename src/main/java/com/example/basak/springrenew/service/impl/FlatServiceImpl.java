package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.dto.TaskInfoDto;
import com.example.basak.springrenew.repository.TaskInfoRepository;
import com.example.basak.springrenew.service.FlatService;
import com.example.basak.springrenew.util.maper.TaskInfoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FlatServiceImpl implements FlatService {

    private final TaskInfoRepository taskInfoRepository;
    private final TaskInfoMapper taskInfoMapper;

    public FlatServiceImpl(TaskInfoRepository taskInfoRepository, TaskInfoMapper taskInfoMapper) {
        this.taskInfoRepository = taskInfoRepository;
        this.taskInfoMapper = taskInfoMapper;
    }

    @Override
    public void startForumScrapeTask(TaskInfoDto taskInfoParams) {
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
    public void saveTaskParams(TaskInfoDto taskInfoParams) {
        taskInfoRepository.save(taskInfoMapper.toEntity(taskInfoParams));
    }



}
