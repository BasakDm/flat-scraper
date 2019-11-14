package com.example.basak.springrenew.service;

import com.example.basak.springrenew.model.UserDetails;

public interface UserService {

    UserDetails findUserByEmail(String email);

    void saveUser(UserDetails userDetails);

    boolean isAuthenticated();

    UserDetails getCurrentUser();

}
