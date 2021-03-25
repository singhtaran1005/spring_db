package com.example.demo.controllers;

import com.example.demo.DAO.Person;
import com.example.demo.DBManager.DBOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping
public class PersonController {

    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public List<Person> getPersons() {

        //calling dao to get the objects from db
        return DBOperations.getPersons();
    }
}
