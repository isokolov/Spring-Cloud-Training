package com.appsdeveloperblog.photoapp.api.users.service;


import com.appsdeveloperblog.photoapp.api.users.dto.UserDto;

interface UsersService {
    UserDto createUser(UserDto userDetails);
}

