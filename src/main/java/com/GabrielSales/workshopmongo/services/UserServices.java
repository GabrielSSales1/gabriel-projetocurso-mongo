package com.GabrielSales.workshopmongo.services;

import com.GabrielSales.workshopmongo.domain.User;
import com.GabrielSales.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){ // retorna uma lista de usuarios
        return repo.findAll();
    }
}
