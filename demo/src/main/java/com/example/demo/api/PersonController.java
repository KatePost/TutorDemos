package com.example.demo.api;

import com.example.demo.exception.StarWarsNotFound;
import com.example.demo.model.People;
import com.example.demo.service.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class PersonController {

    @GetMapping("/person/{id}")
    public ResponseEntity<People> getPerson(@PathVariable("id") int id){
        StarWarsService service = new StarWarsService();
        try{
            return  new ResponseEntity<People>(service.getPerson(id), HttpStatus.OK);
        }
        catch(StarWarsNotFound ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<People> postPerson(@RequestBody People person){
        StarWarsService service = new StarWarsService();
        if(service.addPerson(person) == true){
            return new ResponseEntity<>(person, HttpStatus.OK);
        }else{
            return new ResponseEntity("Could not add", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllPeople")
    public ResponseEntity<ArrayList<People>> getAllPeople(){
        StarWarsService service = new StarWarsService();
        return new ResponseEntity(service.getAllPeople(), HttpStatus.OK);
    }

    @PutMapping("/updatePerson/{name}")
    public ResponseEntity<People> updatePerson(@PathVariable String name, @RequestBody People person){
        StarWarsService service =  new StarWarsService();
        People updated =  service.updatePerson(name, person);
        if(updated != null){
            return new ResponseEntity<People>(updated, HttpStatus.OK);
        }
        return new ResponseEntity("Could not find person", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deletePerson/{name}")
    public ResponseEntity deletePerson(@PathVariable String name){
        StarWarsService service = new StarWarsService();
        if(service.deletePerson(name)){
            return new ResponseEntity("Person " + name + " deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Could not delete " + name, HttpStatus.BAD_REQUEST);
    }

}
