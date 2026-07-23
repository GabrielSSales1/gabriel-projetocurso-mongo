package com.GabrielSales.workshopmongo.services;

import com.GabrielSales.workshopmongo.domain.Post;
import com.GabrielSales.workshopmongo.repository.PostRepository;
import com.GabrielSales.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
