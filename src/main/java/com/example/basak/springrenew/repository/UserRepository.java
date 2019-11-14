package com.example.basak.springrenew.repository;

import com.example.basak.springrenew.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByEmail(String email);

}