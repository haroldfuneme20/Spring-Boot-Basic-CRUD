package com.haroldfuneme.leanteach.crud.controller;

import com.haroldfuneme.leanteach.crud.Model.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class crudController {
    private List<Coffee> coffes =new ArrayList<>();

    public crudController() {
        this.coffes.addAll(List.of(
                new Coffee("Cafe  colombiano"),
                new Coffee("Cafe  brasileño"),
                new Coffee("Cafe  vietnamita")
        ));
    }

    @RequestMapping(value = "/coffees1", method = RequestMethod.GET)
    List<Coffee> getCoffes(){
        return coffes;
    }

    @GetMapping( "/coffees2")
    Iterable<Coffee>getCoffes2(){
        return coffes;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee c: coffes) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffes.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee c: coffes) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffes.indexOf(c);
                coffes.set(coffeeIndex, coffee);
            }
        }

        return (coffeeIndex == -1) ?
                new ResponseEntity<Coffee>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<Coffee>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffes.removeIf(c -> c.getId().equals(id));
    }

}
