package com.example.demo.repositories;

import com.example.demo.models.Friends;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Philip Zamayeri
 * Date: 2021-04-15
 * Time: 10:33
 * Project: demo
 * Copyright: MIT
 */
public interface FriendRepository extends CrudRepository<Friends, Long> {
    List<Friends> findByName(String name);
    List<Friends> findByMail(String mail);
    List<Friends> findByAdress(String adress);
    List<Friends> findByNumber(String number);
}
