package com.example.PhotoAppUser.service;

import com.example.PhotoAppUser.data.UserEntity;
import com.example.PhotoAppUser.usershared.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

 UserDto createUser(UserDto userDetails);

 public List<UserEntity> listAll();

 public Optional<UserEntity> listOne(Long id);

 public void delete(Long id);

 /*UserDto listUsers();*/

}
