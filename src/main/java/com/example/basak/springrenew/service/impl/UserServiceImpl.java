package com.example.basak.springrenew.service.impl;

import com.example.basak.springrenew.model.Role;
import com.example.basak.springrenew.model.UserDetails;
import com.example.basak.springrenew.repository.RoleRepository;
import com.example.basak.springrenew.repository.UserRepository;
import com.example.basak.springrenew.service.UserService;
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

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDetails userDetails) {
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        userDetails.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        if (userRole == null) {
            userRole = new Role();
            userRole.setRole("ADMIN");
            roleRepository.save(userRole);
        }
        userDetails.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        userRepository.save(userDetails);
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
    public UserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userRepository.findByEmail(
                    ((User) authentication.getPrincipal()).getUsername());
        } else {
            return null;
        }
    }

}
