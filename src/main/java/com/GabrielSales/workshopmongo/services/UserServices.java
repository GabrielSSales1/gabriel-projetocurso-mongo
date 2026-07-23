package com.GabrielSales.workshopmongo.services;

import com.GabrielSales.workshopmongo.domain.User;
import com.GabrielSales.workshopmongo.dto.UserDTO;
import com.GabrielSales.workshopmongo.repository.UserRepository;
import com.GabrielSales.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){ // retorna uma lista de usuarios
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }
    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDto(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }
}
