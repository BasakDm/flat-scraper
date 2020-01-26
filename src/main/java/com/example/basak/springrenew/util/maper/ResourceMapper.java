package com.example.basak.springrenew.util.maper;

import com.example.basak.springrenew.model.ResourceEntity;
import com.example.basak.springrenew.model.dto.ResourceDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ResourceMapper extends AbstractMapper<ResourceEntity, ResourceDto> {

    @Override
    public ResourceEntity toEntity(ResourceDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, ResourceEntity.class);
    }

    @Override
    public ResourceDto toDto(ResourceEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ResourceDto.class);
    }

}
