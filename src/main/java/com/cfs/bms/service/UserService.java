package com.cfs.bms.service;

import com.cfs.bms.dto.UserDto;
import com.cfs.bms.model.User;
import com.cfs.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User user = new User();

        return null;
    }

}
