package com.example.basak.springrenew.util.maper;

import com.example.basak.springrenew.model.UserEntity;
import com.example.basak.springrenew.model.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper extends AbstractMapper<UserEntity, UserDto> {

    @Override
    public UserEntity toEntity(UserDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, UserEntity.class);
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UserDto.class);
    }

}
