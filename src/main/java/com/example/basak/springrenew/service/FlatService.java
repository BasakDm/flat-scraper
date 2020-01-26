package com.example.basak.springrenew.service;


import com.example.basak.springrenew.model.dto.TaskInfoDto;

public interface FlatService {

    void startForumScrapeTask(TaskInfoDto taskInfoParams);

    void saveTaskParams(TaskInfoDto taskInfoParams);

}
