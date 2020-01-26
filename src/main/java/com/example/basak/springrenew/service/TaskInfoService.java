package com.example.basak.springrenew.service;


import com.example.basak.springrenew.model.dto.ResourceDto;
import com.example.basak.springrenew.model.dto.TaskInfoDto;

import java.util.Collection;
import java.util.Map;

public interface TaskInfoService {

    void saveTaskInfo(TaskInfoDto taskInfo);

    Collection<TaskInfoDto> getAllTaskForCurrentUser();

    Map<Long, String> getTaskIdToResourceNameMap(Collection<TaskInfoDto> taskInfoCollection);

}
