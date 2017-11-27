package com.jv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jv.entity.User;
import com.jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService userService;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String getUsers() throws JsonProcessingException {
        return mapper.writeValueAsString(userService.getUsers());
    }

    @RequestMapping(value = "/lastname/{lastName}", method = RequestMethod.GET)
    @ResponseBody
    public String getUsersByLastName(@PathVariable String lastName) throws JsonProcessingException{
        return mapper.writeValueAsString(userService.getUsersByLastName(lastName.trim()));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createUser(@RequestBody User user) throws JsonProcessingException{
        System.out.println(user.getTitle() + user.getFirstname() + user.getLastname() + user.getDob() + user.isIsActive());

        User u = new User(user.getTitle(), user.getFirstname(), user.getLastname(), user.getDob(), user.isIsActive());
         if(userService.save(u))
             return new ResponseEntity<String>(HttpStatus.OK);
         else
             return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws JsonProcessingException{
        if(userService.delete(id))
            return new ResponseEntity<String>(HttpStatus.OK);
        else
            return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
    }
}
