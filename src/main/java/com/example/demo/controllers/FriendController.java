package com.example.demo.controllers;

import com.example.demo.models.Friends;
import com.example.demo.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Philip Zamayeri
 * Date: 2021-04-15
 * Time: 10:52
 * Project: demo
 * Copyright: MIT
 */
@Controller
@CrossOrigin
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping(path="/add/{name}/{mail}/{adress}/{number}")
    public @ResponseBody String addFriend(@PathVariable String name,
                            @PathVariable String mail,
                            @PathVariable String adress,
                            @PathVariable String number){
        System.out.println(name + mail + adress + number);

        Friends f = new Friends();
        f.setName(name);
        f.setMail(mail);
        f.setAdress(adress);
        f.setNumber(number);
        friendRepository.save(f);
        return name + " added";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Friends> getAllFriends() {
        return friendRepository.findAll();
    }

    @GetMapping(path = "/search/{name}")
    public @ResponseBody String getFriendByName(@PathVariable String name){
        return friendRepository.findByName(name).toString();
    }

    @GetMapping(path = "/search/{number}")
    public @ResponseBody String getFriendByNumber(@PathVariable String number){
        return friendRepository.findByNumber(number).toString();
    }

    @GetMapping(path = "/delete/{id}")
    public @ResponseBody String deleteFriendById(@PathVariable Long id){
        friendRepository.deleteById(id);
        return "Din vän är borttagen";
    }

    @GetMapping(path = "/update/{id}/{number}")
    public @ResponseBody String updateFriend(@PathVariable Long id, @PathVariable String number){
       Optional<Friends> opFriend = friendRepository.findById(id);
       if (opFriend.isPresent()){
           opFriend.get().setNumber(number);
           friendRepository.save(opFriend.get());
           return "Din vän har uppdaterats";
       }
       else return "Din vän finns ej i databasen";
    }
}
