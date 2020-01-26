package com.example.basak.springrenew.util.maper;

import com.example.basak.springrenew.model.TaskInfoEntity;
import com.example.basak.springrenew.model.dto.TaskInfoDto;
import com.example.basak.springrenew.repository.TaskInfoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class TaskInfoMapper extends AbstractMapper<TaskInfoEntity, TaskInfoDto> {

    private final TaskInfoRepository taskInfoRepository;

    public TaskInfoMapper(TaskInfoRepository taskInfoRepository) {
        this.taskInfoRepository = taskInfoRepository;
    }

    @Override
    public TaskInfoEntity toEntity(TaskInfoDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, TaskInfoEntity.class);
    }

    @Override
    public TaskInfoDto toDto(TaskInfoEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TaskInfoDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(TaskInfoEntity.class, TaskInfoDto.class)
                .addMappings(m -> m.skip(TaskInfoDto::setUserId))
                .addMappings(m -> m.skip(TaskInfoDto::setResourceId))
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(TaskInfoDto.class, TaskInfoEntity.class)
                .addMappings(m -> m.skip(TaskInfoEntity::setUser))
                .addMappings(m -> m.skip(TaskInfoEntity::setResource))
                .setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificEntityFields(TaskInfoEntity source, TaskInfoDto destination) {
        destination.setResourceId(Objects.isNull(source) ? null : source.getResource().getId());
        destination.setResourceId(Objects.isNull(source) ? null : source.getUser().getId());
    }

    @Override
    void mapSpecificDtoFields(TaskInfoDto source, TaskInfoEntity destination) {
        TaskInfoEntity taskInfo = taskInfoRepository.findById(source.getId()).orElse(null);
        destination.setResource(Objects.isNull(taskInfo) ? null : taskInfo.getResource());
        destination.setUser(Objects.isNull(taskInfo) ? null : taskInfo.getUser());
    }

}
