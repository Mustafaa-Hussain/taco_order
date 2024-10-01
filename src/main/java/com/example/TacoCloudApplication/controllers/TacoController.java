package com.example.TacoCloudApplication.controllers;


import com.example.TacoCloudApplication.data.Taco;
import com.example.TacoCloudApplication.repositoies.TacoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
public class TacoController {
    private TacoRepository tacoRepo;

    public TacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Optional<Taco> getTacoById(@PathVariable("id") Long id) {
        return tacoRepo.findById(id);
    }


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

    //    we follow the meaning of put "put update the entire record
    @PutMapping(path = "/{id}", consumes = "application/json")
    public Taco putTaco(@PathVariable("id") Long id, @RequestBody Taco updatedTaco) {
        return tacoRepo.save(updatedTaco);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Taco patchTaco(@PathVariable("id") Long id, @RequestBody Taco updatedTaco) {
        Taco oldTaco = tacoRepo.findById(id).get();
        if (updatedTaco.getName() != null)
            oldTaco.setName(updatedTaco.getName());
        if (updatedTaco.getIngredients() != null)
            oldTaco.setIngredients(updatedTaco.getIngredients());
        if (updatedTaco.getCreatedAt() != null)
            oldTaco.setCreatedAt(updatedTaco.getCreatedAt());

        return tacoRepo.save(oldTaco);
    }

    @DeleteMapping(path = "/{id}", consumes = "application/json")
    public void deleteTaco(@PathVariable("id") Long id){
        try {
            tacoRepo.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
