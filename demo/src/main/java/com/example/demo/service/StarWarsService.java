package com.example.demo.service;

import com.example.demo.adapter.StarWarsAdapter;
import com.example.demo.exception.StarWarsNotFound;
import com.example.demo.model.People;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StarWarsService {

    static ArrayList<People> people = new ArrayList<>();

    public People getPerson(int id){
        StarWarsAdapter adapter = new StarWarsAdapter();

        People person = adapter.callStarWarsApi(id);

        people.add(person);
        return person;
    }

    public boolean addPerson(People person){
        people.add(person);
        return true;
    }

    public ArrayList<People> getAllPeople(){
        return people;
    }

    public People updatePerson(String name, People update){
        for (People person: people) {
            if(person.getName().equals(name)){
                person.setGender(update.getGender());
                person.setHeight(update.getHeight());
                person.setMass(update.getMass());
                person.setName(update.getName());
                return person;
            }
        }
        return null;
    }

    public boolean deletePerson(String name){
        for(People person : people){
            if(person.getName().equals(name)){
                people.remove(person);
                return true;
            }
        }

        return false;
    }
}
