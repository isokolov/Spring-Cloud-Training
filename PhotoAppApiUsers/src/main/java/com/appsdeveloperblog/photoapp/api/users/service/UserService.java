package com.appsdeveloperblog.photoapp.api.users.service;


import com.appsdeveloperblog.photoapp.api.users.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}

