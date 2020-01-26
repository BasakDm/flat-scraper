package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.ResourceEntity;
import com.example.basak.springrenew.model.dto.ResourceDto;
import com.example.basak.springrenew.model.dto.TaskInfoDto;
import com.example.basak.springrenew.model.dto.UserDto;
import com.example.basak.springrenew.repository.ResourceRepository;
import com.example.basak.springrenew.repository.TaskInfoRepository;
import com.example.basak.springrenew.service.ResourceService;
import com.example.basak.springrenew.service.TaskInfoService;
import com.example.basak.springrenew.service.UserService;
import com.example.basak.springrenew.util.maper.TaskInfoMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskInfoServiceImpl implements TaskInfoService {

    private final TaskInfoRepository taskInfoRepository;
    private final UserService userService;
    private final TaskInfoMapper taskInfoMapper;
    //TODO replace
    private final ResourceRepository resourceRepository;
    private final ResourceService resourceService;

    public TaskInfoServiceImpl(TaskInfoRepository taskInfoRepository,
                               UserService userService,
                               TaskInfoMapper taskInfoMapper,
                               ResourceRepository resourceRepository, ResourceService resourceService) {
        this.taskInfoRepository = taskInfoRepository;
        this.userService = userService;
        this.taskInfoMapper = taskInfoMapper;
        this.resourceRepository = resourceRepository;
        this.resourceService = resourceService;
    }

    @Override
    public void saveTaskInfo(TaskInfoDto taskInfo) {
        //TODO throws exception if task without resource
        ResourceEntity resource = resourceRepository.findById(1L).orElse(null);
        if (resource == null) {
//            resource = ResourceEntity.builder()
//                    .name("Forum")
//                    .url("https://forum.grodno.net/index.php?board=346.0;sort=first_post;desc")
//                    .build();
//            resourceRepository.save(resource);
        }
        taskInfo.setUserId(userService.getCurrentUser().getId());
        taskInfo.setResourceId(resource.getId());
        taskInfoRepository.save(taskInfoMapper.toEntity(taskInfo));
    }

    @Override
    public Collection<TaskInfoDto> getAllTaskForCurrentUser() {
        UserDto currentUser = userService.getCurrentUser();
        return currentUser == null ? Collections.EMPTY_SET : currentUser.getTasks();
    }

    @Override
    public Map<Long, String> getTaskIdToResourceNameMap(Collection<TaskInfoDto> taskInfoCollection) {
        Map<Long, String> result = new HashMap<>();
        taskInfoCollection
                .forEach(t -> result.put(t.getId(), resourceService.getById(t.getResourceId()).getName()));
        return result;
    }

}
