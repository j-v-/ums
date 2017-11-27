package com.jv.service;

import com.jv.db.service.UserRepository;
import com.jv.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public List<User> getUsersByLastName(String lastName){
        return userRepository.find(lastName);
    }

    public boolean save(User user) {
        try {
            userRepository.save(user);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Long id) {
        try{
            userRepository.delete(id);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getMockData(){
        List<User> users = new ArrayList<User>();
        User user1 = new User("Mr", "Tony", "Stark", new Date(), true);
        User user2 = new User("Mr", "Captain", "America", new Date(), true);
        User user3 = new User("Mr", "Black", "Widow", new Date(), true);
        User user4 = new User("Mr", "Black", "Panther", new Date(), false);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }



}


