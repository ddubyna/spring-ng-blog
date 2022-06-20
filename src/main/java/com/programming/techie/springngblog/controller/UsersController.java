package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.UserDto;
import com.programming.techie.springngblog.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> showAllPosts() {
        return new ResponseEntity<>(userService.showAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(userService.readSingleUser(id), HttpStatus.OK);
    }
}
