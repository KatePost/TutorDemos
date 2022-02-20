package com.example.demo.adapter;

import com.example.demo.exception.StarWarsNotFound;
import com.example.demo.model.People;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class StarWarsAdapter {

    public People callStarWarsApi(int id){
        String url = "https://swapi.py4e.com/api/people/" + id;

            RestTemplate restTemplate = new RestTemplate();
            People person = restTemplate.getForObject(url, People.class);
            return person;

    }
}
