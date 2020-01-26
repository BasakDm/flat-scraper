package com.example.basak.springrenew.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfoDto {
    private long id;
    @Min(value = 3, message = "The minimum period between scans is 3 minutes")
    private int period;
    private Long userId;
    private Long resourceId;
}
