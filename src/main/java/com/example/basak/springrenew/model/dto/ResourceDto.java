package com.example.basak.springrenew.model.dto;

import com.example.basak.springrenew.model.TaskInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDto {
    private long id;
    @NotEmpty(message = "*Please provide an resource name")
    private String name;
    private String description;
    @NotEmpty(message = "*Please provide an email")
    @URL(protocol = "http", message = "Please provide an HTTP URL")
    private String url;
    private Set<TaskInfoEntity> tasks;
}
