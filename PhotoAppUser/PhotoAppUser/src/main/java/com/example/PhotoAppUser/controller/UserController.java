package com.example.PhotoAppUser.controller;

import com.example.PhotoAppUser.data.UserEntity;
import com.example.PhotoAppUser.data.UserRepository;
import com.example.PhotoAppUser.model.Account;
import com.example.PhotoAppUser.model.User;
import com.example.PhotoAppUser.model.UserResource;
import com.example.PhotoAppUser.service.UserService;
import com.example.PhotoAppUser.usershared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/status")

    public String status()
    {
        return "working on port "+environment.getProperty("local.server.port");

    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User user){

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto=modelMapper.map(user,UserDto.class);

        userService.createUser(userDto);


        return new ResponseEntity(HttpStatus.CREATED);


    }




    @GetMapping
    public  List<UserEntity> listUsers(){
        return userService.listAll();

    }

    /*@GetMapping("/{id}")

 public Optional<UserEntity> listUser(@PathVariable Long id){

        Optional<UserEntity> userEntity=userRepository.findById(id);
        return  userEntity;

    }*/


    @GetMapping("/{id}")
    public Optional<UserEntity> listUser(@PathVariable Long id){
        return userService.listOne(id);
    }



    @DeleteMapping("/{id}")

    public void deleteUser(@PathVariable Long id){

        userService.delete(id);

    }

    @GetMapping("/communication")
    public List<UserResource> communicate(){
        RestTemplate restTemplate=new RestTemplate();
        List<Account> accounts= Arrays.asList(
                new Account("Zayn",2),
                new Account("John",3)
        );
      return   accounts.stream().map(account -> {
          Account accountObj=  restTemplate.getForObject("http://localhost:3030/accounts",Account.class);
          return new UserResource(accountObj.getName(), "GoalKeeper");
      }).collect(Collectors.toList());

    }




}
