package com.example.basak.springrenew.service;

import com.example.basak.springrenew.model.TaskInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FlatService {

    void startForumScrapeTask(TaskInfo taskInfoParams);

    void saveTaskParams(TaskInfo taskInfoParams);

    List<TaskInfo> getAllTaskParams();

}
