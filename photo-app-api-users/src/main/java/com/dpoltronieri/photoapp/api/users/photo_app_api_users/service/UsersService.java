package com.dpoltronieri.photoapp.api.users.photo_app_api_users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dpoltronieri.photoapp.api.users.photo_app_api_users.shared.UserDto;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}
