package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.RoleEntity;
import com.example.basak.springrenew.model.UserEntity;
import com.example.basak.springrenew.model.dto.UserDto;
import com.example.basak.springrenew.repository.RoleRepository;
import com.example.basak.springrenew.repository.UserRepository;
import com.example.basak.springrenew.service.UserService;
import com.example.basak.springrenew.util.maper.UserMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }

    @Override
    public void saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        RoleEntity userRole = roleRepository.findByRole("ADMIN");
        if (userRole == null) {
            userRole = new RoleEntity();
            userRole.setRole("ADMIN");
            roleRepository.save(userRole);
        }
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.isAuthenticated();
        } else {
            return false;
        }
    }

    @Override
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userMapper.toDto(
                    userRepository.findByEmail(
                            ((User) authentication.getPrincipal()).getUsername()));
        } else {
            return null;
        }
    }

}
