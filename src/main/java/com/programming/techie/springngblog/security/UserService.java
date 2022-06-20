package com.programming.techie.springngblog.security;

import com.programming.techie.springngblog.dto.UserDto;
import com.programming.techie.springngblog.exception.UserNotFoundException;
import com.programming.techie.springngblog.model.User;
import com.programming.techie.springngblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<UserDto> showAllUsers() {
        List<User> posts = userRepository.findAll();
        return posts.stream().map(this::mapFromUserToDto).collect(toList());
    }

    @Transactional
    public UserDto readSingleUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("For id " + id));
        return mapFromUserToDto(user);
    }

    private UserDto mapFromUserToDto(User user) {
        UserDto UserDto = new UserDto();
        UserDto.setId(user.getId());
        UserDto.setEmail(user.getEmail());
        UserDto.setUsername(user.getUserName());
        return UserDto;
    }
}
