package com.GabrielSales.workshopmongo.resources;

import com.GabrielSales.workshopmongo.domain.Post;
import com.GabrielSales.workshopmongo.resources.util.URL;
import com.GabrielSales.workshopmongo.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostServices service;

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/titlesearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}