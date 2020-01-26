package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.dto.ResourceDto;
import com.example.basak.springrenew.repository.ResourceRepository;
import com.example.basak.springrenew.service.ResourceService;
import com.example.basak.springrenew.util.maper.ResourceMapper;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository,
                               ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public ResourceDto getById(Long id) {
        return resourceMapper.toDto(resourceRepository.findById(id).orElse(null));
    }

}
