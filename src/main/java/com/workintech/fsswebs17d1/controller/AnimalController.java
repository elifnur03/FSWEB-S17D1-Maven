package com.workintech.fsswebs17d1.controller;

import com.workintech.fsswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init() {
        animals = new HashMap<>();
    }

    // GET ALL
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // POST
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    // PUT
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
        return "Animal deleted";
    }

}

