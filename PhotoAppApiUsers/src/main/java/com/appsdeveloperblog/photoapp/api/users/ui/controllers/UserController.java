package com.appsdeveloperblog.photoapp.api.users.ui.controllers;


import com.appsdeveloperblog.photoapp.api.users.dto.UserDto;
import com.appsdeveloperblog.photoapp.api.users.service.UserServiceImpl;
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    Environment env;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port " + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");
    }

    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);

        CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

        //return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }
}
