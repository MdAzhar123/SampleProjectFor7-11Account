package com.example.PhotoAppUser.service;

import com.example.PhotoAppUser.data.UserEntity;
import com.example.PhotoAppUser.data.UserRepository;
import com.example.PhotoAppUser.usershared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto) {

        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);

        userEntity.setEncryptedPassword("test2");

        System.out.println("######################################################################Before");

        userRepository.save(userEntity);

        System.out.println("############################################################################");

        return null;
    }


    /*public UserDto listUsers(){


        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto=modelMapper.map(userRepository.findAll(),UserDto.class);


        System.out.println(userDto);


        return userDto;

    }*/


    public List<UserEntity> listAll(){
        return (List<UserEntity>) userRepository.findAll();
    }

    public Optional<UserEntity> listOne(Long id){
        Optional<UserEntity> userEntity=userRepository.findById(id);
        return userEntity;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }


}
