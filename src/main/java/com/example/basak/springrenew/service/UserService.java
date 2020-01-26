package com.example.basak.springrenew.service;

import com.example.basak.springrenew.model.UserEntity;
import com.example.basak.springrenew.model.dto.UserDto;

public interface UserService {

    UserDto findUserByEmail(String email);

    void saveUser(UserEntity user);

    boolean isAuthenticated();

    UserDto getCurrentUser();

}
