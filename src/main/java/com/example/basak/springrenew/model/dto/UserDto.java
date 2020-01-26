package com.example.basak.springrenew.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String name;
    private Set<TaskInfoDto> tasks;
}
